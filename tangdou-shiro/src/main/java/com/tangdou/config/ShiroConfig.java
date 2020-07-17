package com.tangdou.config;

import cn.hutool.core.collection.CollUtil;
import com.tangdou.config.realms.MyShiroCasRealm;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/7/8 17:24
 * @Description:
 */
//@Configuration
public class ShiroConfig {

    /**
     * 免登录白名单 ///todo 作为配置提取出来
     */
    private List<String> WHITE_LIST = CollUtil.toList(
            "/api/auth/**", "/doc.html", "/**/*.js", "/**/*.css", "/**/*.html", "/**/*.svg", "/**/*.pdf",
            "/**/*.jpg", "/**/*.png", "/**/*.ico", "/**/*.ttf", "/**/*.woff", "/druid/**", "/swagger-ui.html", "/swagger**/**",
            "/webjars/**", "/v2/**", "/api/user/avatar/*"
    );

    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(MyShiroCasRealm userRealm, CasSubjectFactory subjectFactory) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        /*
         * 关闭shiro自带的session，详情见文档
         * http://shiro.apache.org/session-management.html#SessionManagement-
         * StatelessApplications%28Sessionless%29
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        securityManager.setSubjectFactory(subjectFactory);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        //设置我们自定义的JWT过滤器
        filterMap.put("casFilter", casFilter());
        shiroFilterFactoryBean.setLoginUrl("https://tangdou.com?service=http://localhost:9001/get");
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了
         * authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
         */
        Map<String, String> chainDefinitionMap = WHITE_LIST.stream()
                .collect(Collectors.toMap(x -> x, x -> "anon", (existing, replacement) -> existing, LinkedHashMap::new));

        chainDefinitionMap.put("/login", "casFilter");
        chainDefinitionMap.put("/shiro/*", "anon");
        chainDefinitionMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(chainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    public CasFilter casFilter(){
        CasFilter casFilter = new CasFilter();
//        casFilter.setLoginUrl("https://tangdou.com?service=http://localhost:9001/get");
//        casFilter.setFailureUrl("https://tangdou.com?service=http://localhost:9001/get");
        return casFilter;
    }


    /**
     * 下面的代码是添加注解支持
     *
     * @return
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    // =========================================== CAS 相关配置 ==============================
    @Bean
    public CasSubjectFactory casSubjectFactory() {
        return new CasSubjectFactory();
    }
}
