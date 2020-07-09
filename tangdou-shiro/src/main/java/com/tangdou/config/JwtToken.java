package com.tangdou.config;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义JWT Token
 *
 * @author 白振伟
 * @version V1.0
 * @date 2020年04月29日 11:44
 */
@AllArgsConstructor
public class JwtToken implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
