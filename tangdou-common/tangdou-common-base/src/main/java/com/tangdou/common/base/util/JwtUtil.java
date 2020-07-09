package com.tangdou.common.base.util;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.tangdou.common.base.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static com.tangdou.common.base.enums.GeneralResultCode.ERROR_TOKEN;

/**
 * JWT 工具类
 *
 * @author 白振伟
 * @version V1.0
 * @date 2020年04月29日 11:39:58
 */
@Slf4j
public class JwtUtil {
    /**
     * 过期时间 24 小时
     */
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;
    public static final String PREFIX_USER_TOKEN = "prefix_user_token_";
    /**
     * 密钥
     */
    private static final String SECRET = "SHIRO+JWT";

    /**
     * 生成签名,5min后过期
     *
     * @param loginName 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String loginName, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create().withClaim("loginName", loginName).withExpiresAt(date).sign(algorithm);
    }

    /**
     * 校验token是否正确
     *
     * @param token    密钥
     * @param loginName 用户名
     * @param secret   用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String loginName, String secret) {
        try {
            // 根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("loginName", loginName).build();
            // 效验TOKEN
            verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息，无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("loginName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 根据request中的token获取用户账号
     *
     * @param request
     * @return
     * @throws GlobalException
     */
    public static String getUserNameByToken(HttpServletRequest request) throws GlobalException {
        String accessToken = request.getHeader("Access-Token");
        String loginName = getUserName(accessToken);
        if (StrUtil.isBlank(loginName)) {
            throw new GlobalException(ERROR_TOKEN);
        }
        return loginName;
    }

    /**
     * JWTToken刷新生命周期 （实现： 用户在线操作不掉线功能）
     * 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)，缓存有效期设置为Jwt有效时间的2倍
     * 2、当该用户再次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
     * 3、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
     * 4、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
     * 注意： 前端请求Header中设置Authorization保持不变，校验有效性以缓存中的token为准。
     * 用户过期时间 = Jwt有效时间 * 2。
     *
     * @param loginName
     * @param passWord
     * @return
     */
    public static boolean jwtTokenRefresh(String token, String loginName, String passWord) {
        String cacheToken = String.valueOf(RedisUtil.get(PREFIX_USER_TOKEN + token));
        if (StrUtil.isNotBlank(cacheToken)) {
            // 校验token有效性
            if (!JwtUtil.verify(cacheToken, loginName, passWord)) {
                String newAuthorization = JwtUtil.sign(loginName, passWord);
                // 设置超时时间
                RedisUtil.set(PREFIX_USER_TOKEN + token, newAuthorization);
                RedisUtil.expire(PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME * 2 / 1000);
            } else {
                // 设置超时时间
                RedisUtil.set(PREFIX_USER_TOKEN + token, cacheToken);
                RedisUtil.expire(PREFIX_USER_TOKEN + token, JwtUtil.EXPIRE_TIME / 1000);
            }
            return true;
        }
        return false;
    }
}
