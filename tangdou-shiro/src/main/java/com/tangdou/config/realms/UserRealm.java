package com.tangdou.config.realms;

import cn.hutool.core.util.StrUtil;
import com.tangdou.common.base.util.JwtUtil;
import com.tangdou.config.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA
 *
 * @author: baizw
 * Date: 2018/3/6
 * Time: 22:52
 */
@Component
@Slf4j
public class UserRealm extends AuthorizingRealm {

    /**
     * 必须重写此方法，不然会报错
     *
     * @param token token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
     * 也就是说验证用户输入的账号和密码是否正确，错误抛出异常
     *
     * @param auth 用户登录的账号密码信息
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        if (StrUtil.isBlank(token)) {
            throw new AuthenticationException("token为空!");
        }

        // 解密获得username，用于和数据库进行对比
        String loginName = JwtUtil.getUserName(token);
        if (loginName == null) {
            throw new AuthenticationException("token非法无效!");
        }
/*
        // 查询用户信息
        log.info("———校验token是否有效————checkUserTokenIsEffect——————— " + token);
        UserEntity loginUser = userService.selectByUserName(loginName);
        if (loginUser == null) {
            throw new AuthenticationException("用户不存在!");
        }
        // 判断用户状态
        if (StatusEnum.LOCKED.equals(loginUser.getStatus())) {
            throw new AuthenticationException("账号已被锁定,请联系管理员!");
        }
        // 校验token是否超时失效 & 或者账号密码是否错误
        if (!JwtUtil.jwtTokenRefresh(token, loginName, loginUser.getPassword())) {
            throw new AuthenticationException("Token失效，请重新登录!");
        }*/
        return null;
    }


    /**
     * 清除当前用户的权限认证缓存
     *
     * @param principals 权限信息
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       /* UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
        if (userEntity == null) {
            throw new GlobalException(ResultEnum.USER_NOT_FOUND);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = securityService.roles(userEntity.getId());
        if (CollUtil.isNotEmpty(roles)) {
            //添加角色信息到授权中心
            info.setRoles(roles);
        }
        Set<String> stringPermissions = securityService.stringPermissions(userEntity.getId());
        if (CollUtil.isNotEmpty(stringPermissions)) {
            //添加权限信息到授权中心
            info.setStringPermissions(stringPermissions);
        }*/
        return null;
    }
}
