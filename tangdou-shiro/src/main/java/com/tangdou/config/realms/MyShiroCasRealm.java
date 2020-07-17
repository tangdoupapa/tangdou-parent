package com.tangdou.config.realms;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;


public class MyShiroCasRealm extends CasRealm {

    /**
     * 权限认证，为当前登录的Subject授予角色和权限
     * 本例中该方法的调用时机为需授权资源被访问时
     * 并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
     * 如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），超过这个时间间隔再刷新页面，该方法会被执行
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取单点登陆后的用户名，也可以从session中获取，因为在认证成功后，已经将用户名放到session中去了
        String userName = (String) super.getAvailablePrincipal(principals);
//				principals.getPrimaryPrincipal(); 这种方式也可以获取用户名

        // 根据用户名获取该用户的角色和权限信息
//		UserInfo userInfo = userInfoService.findByUsername(userName);
//
//		// 将用户对应的角色和权限信息打包放到AuthorizationInfo中
//		for (SysRole role : userInfo.getRoleList()) {
//			authorizationInfo.addRole(role.getRole());
//			for (SysPermission p : role.getPermissions()) {
//				authorizationInfo.addStringPermission(p.getPermission());
//			}
//		}
        return authorizationInfo;
    }

    /**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中(不用了，随时可以获取的)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        AuthenticationInfo authenticationInfo = super.doGetAuthenticationInfo(token);
        String name = (String) authenticationInfo.getPrincipals().getPrimaryPrincipal();
        SecurityUtils.getSubject().getSession().setAttribute("name", name);
        return authenticationInfo;
    }

}
