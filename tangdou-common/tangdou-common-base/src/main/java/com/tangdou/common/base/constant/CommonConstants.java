package com.tangdou.common.base.constant;

/**
 * 系统常量
 *
 * @author 白振伟
 * @version V1.0
 * @date 2018年04月17日 10:13
 */
public class CommonConstants {
    public static final String UNKNOWN = "unknown";
    public static final String LOCAL_IPV4 = "127.0.0.1";
    public static final String LOCAL_IPV6 = "0:0:0:0:0:0:0:1";

    /**
     * 获取真实IP地址并获取位置信息
     */
    public static final String GET_IP_REAL = "http://ip.chinaz.com/getip.aspx";

    public static final String AUTHC_HEADER = "Access-Token";

    /**
     * 登录用户规则缓存
     */
    public static final String LOGIN_USER_CACHE = "login_user_rules_";

    /**
     * 登录用户拥有角色缓存KEY前缀
     */
    public static final String LOGIN_USER_ROLE_CACHE = "login_user_role_rules";

    /**
     * 登录用户拥有权限缓存KEY前缀
     */
    public static final String LOGIN_USER_PERMISSION_CACHE = "login_user_permission_rules";

}
