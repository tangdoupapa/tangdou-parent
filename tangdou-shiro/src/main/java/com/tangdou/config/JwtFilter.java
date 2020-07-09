package com.tangdou.config;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.tangdou.common.base.constant.CommonConstants;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * JWT Token 过滤器
 * preHandle->isAccessAllowed->isLoginAttempt->executeLogin
 *
 * @author 白振伟
 * @version V1.0
 * @date 2020年04月29日 11:52:20
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 如果带有 token，则对 token 进行检查，否则直接通过
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return
     * @throws UnauthorizedException 未授权异常
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean loggedIn = false;
        if (this.isLoginAttempt(request, response)) {
            loggedIn = this.executeLogin(request, response);
        }

        if (!loggedIn) {
            this.sendChallenge(request, response);
        }

        return loggedIn;
    }

    /**
     * 判断用户是否想要登入。
     * 检测 header 里面是否包含 Token 字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return StrUtil.isNotBlank(getTokenFromRequest(request));
    }

    /**
     * 执行登陆操作
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        String token = getTokenFromRequest(request);
        if (null == token) {
            String msg = "用户登录方法令牌不能为null";
            throw new IllegalStateException(msg);
        }
        //交给realm判断是否有权限,没权限返回false交给onAccessDenied
        JwtToken jwtToken = new JwtToken(token);
        try {
            this.getSubject(request, response).login(jwtToken);
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
    }

    /**
     * 构建未授权的请求返回,filter层的异常不受exceptionAdvice控制,这里返回401,把返回的json丢到response中
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return 成功/失败
     */
    @Override
    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        String contentType = "application/json;charset=" + CharsetUtil.UTF_8;
        httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpResponse.setContentType(contentType);
        try {
            String msg = "对不起,您无权限进行操作!";
            Result unauthorized = ResultUtil.fail(HttpStatus.UNAUTHORIZED.value(), msg);
            PrintWriter printWriter = httpResponse.getWriter();
            printWriter.append(JSONUtil.toJsonStr(unauthorized));
        } catch (IOException e) {
            log.error("sendChallenge error,can not resolve httpServletResponse");
        }
        return false;
    }

    /**
     * 请求前处理,处理跨域
     *
     * @param request  ServletRequest
     * @param response ServletResponse
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时,option请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    /**
     * 从请求中获取认证信息
     *
     * @param request 请求
     * @return token
     */
    private static String getTokenFromRequest(ServletRequest request) {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        String authcHeader = httpServletRequest.getHeader(CommonConstants.AUTHC_HEADER);
        if (StrUtil.isNotBlank(authcHeader)) {
            return authcHeader;
        }
        String parameter = httpServletRequest.getParameter(CommonConstants.AUTHC_HEADER);
        if (StrUtil.isNotBlank(parameter)) {
            return parameter;
        }
        String parameter1 = httpServletRequest.getParameter("token");
        if (StrUtil.isNotBlank(parameter1)) {
            return parameter1;
        }
        return StrUtil.EMPTY;
    }
}
