package com.tangdou.config;

import com.tangdou.config.filter.MyCasFilter;
import com.tangdou.config.realms.MyShiroCasRealm;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroCasConfiguration {
	//    cas 的server地址
//	public static final String casServerUrlPrefix = "https://www.royal.com:8443/cas";
	public static final String casServerUrlPrefix = "http://SERVER";
	//    cas 登录页面的地址
	public static final String casLoginUrl = casServerUrlPrefix + "/login";
	//    cas 登出页面地址
	public static final String casLogoutUrl = casServerUrlPrefix + "/logout";
	//    对外提供的服务地址
	public static final String shiroServerUrlPrefix = "http://client:9001";
	//    casFilter cas 拦截的地址
	public static final String casFilterUrlPattern = "/shiro_cas";
	//    登录成功的地址

	public static final String loginSuccessUrl = "/index";
	//    登录的地址
	public static final String loginUrl = casLoginUrl + "?service=" + shiroServerUrlPrefix + casFilterUrlPattern;
	//    退出的地址
	public static final String logoutUrl = casLogoutUrl + "?service=" + casLogoutUrl;
	//    失败的地址
	public static final String unauthorizedUrl = "/403";

	@Bean("securityManager")
	public DefaultWebSecurityManager securityManager(MyShiroCasRealm userRealm, CasSubjectFactory subjectFactory) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
//        指定shiro
		defaultWebSecurityManager.setRealm(userRealm);
//        指定subjectFactory，如果实现的cas的remember me（免登录） 的功能，
		defaultWebSecurityManager.setSubjectFactory(subjectFactory);
		DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
		DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
		defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
		subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
		defaultWebSecurityManager.setSubjectDAO(subjectDAO);

		return defaultWebSecurityManager;
	}

	@Bean
	public MyShiroCasRealm myShiroCasRealm() {
		MyShiroCasRealm myShiroCasRealm = new MyShiroCasRealm();
//        设置cas登录服务器地址的前缀
		myShiroCasRealm.setCasServerUrlPrefix(casServerUrlPrefix);
//        客户端回调地址，登录成功后的跳转的地址（自己的服务器）
		myShiroCasRealm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
		return myShiroCasRealm;
	}

//	注册单点登出的listener
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public ServletListenerRegistrationBean servletListenerRegistrationBean() {
		ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean();
		bean.setListener(new SingleSignOutHttpSessionListener());
		bean.setEnabled(true);
		return bean;
	}
 
//	注册单点登出filter
	@Bean
	public FilterRegistrationBean registrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setName("registrationBean");
		registrationBean.setFilter(new SingleSignOutFilter());
		registrationBean.addUrlPatterns("/*");//拦截所有的请求
		registrationBean.setEnabled(true);
		registrationBean.setOrder(10);//设置优先级
		return registrationBean;
	}
 
//	注册DelegatingFilterProxy（Shiro）
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new DelegatingFilterProxy("shiroFilter")); //设置的shiro的拦截器 ShiroFilterFactoryBean
		bean.addInitParameter("targetFilterLifecycle", "true");
		bean.setEnabled(true);
		bean.addUrlPatterns("/*");
		return bean;
	}
 
	//	该类可以保证实现了org.apache.shiro.util.Initializable接口的shiro对象的init或者是destory方法被自动调用，
//	而不用手动指定init-method或者是destory-method方法
//	注意：如果使用了该类，则不需要手动指定初始化方法和销毁方法，否则会出错
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}
 
//	下面两个配置主要用来开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
//        设置代理方式，true是cglib的代理方式，false是普通的jdk代理方式
		proxyCreator.setProxyTargetClass(true);
		return proxyCreator;
	}
 
	//    开启注解
	@Bean
	public AuthorizationAttributeSourceAdvisor attributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
 
//	使用工厂模式，创建并初始化ShiroFilter
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager, CasFilter casFilter) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		factoryBean.setSecurityManager(securityManager);
//        如果不设置，会自动寻找目录下的/login.jsp页面
		factoryBean.setLoginUrl(loginUrl);
		factoryBean.setSuccessUrl("/index");
//        设置无权限访问页面
		factoryBean.setUnauthorizedUrl(unauthorizedUrl);
//        添加casFilter中，注意，casFilter需要放到shiroFilter的前面
		Map<String, Filter> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put("casFilter", casFilter);
 
		factoryBean.setFilters(linkedHashMap);
		loadShiroFilterChain(factoryBean);
		return factoryBean;
	}
 
//	CAS过滤器
	@Bean(name = "casFilter")
	public CasFilter getCasFilter() {
		MyCasFilter casFilter = new MyCasFilter();
		casFilter.setName("casFilter");
		casFilter.setEnabled(true);
		casFilter.setFailureUrl(loginUrl);
//		casFilter.setLoginUrl(loginUrl);
//		casFilter.setLoginUrl("/index");
		casFilter.setSuccessUrl("/index");
		return casFilter;
 
	}
 
	private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean) {
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
 
		filterChainDefinitionMap.put(casFilterUrlPattern, "casFilter");
 
		//2.不拦截的请求
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
//		filterChainDefinitionMap.put("/login", "anon");
//		filterChainDefinitionMap.put("/index", "anon");
//		filterChainDefinitionMap.put("/verify", "anon");
		// 此处将logout页面设置为anon，而不是logout，因为logout被单点处理，而不需要再被shiro的logoutFilter进行拦截
		filterChainDefinitionMap.put("/logout", "anon");
		filterChainDefinitionMap.put("/error", "anon");
		//3.拦截的请求（从本地数据库获取或者从casserver获取(webservice,http等远程方式)，看你的角色权限配置在哪里）
		filterChainDefinitionMap.put("/user", "authc"); //需要登录
 
		//4.登录过的不拦截
		filterChainDefinitionMap.put("/**", "authc");
 
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
	}

	@Bean
	public CasSubjectFactory subjectFactory() {
		return new CasSubjectFactory();
	}
}