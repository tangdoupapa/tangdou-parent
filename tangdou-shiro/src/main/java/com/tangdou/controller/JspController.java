package com.tangdou.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@Controller
public class JspController {
 
	@RequestMapping("/index")
	public String  index() {
        return "index";
	}
 
    @RequestMapping(value="logout",method =RequestMethod.GET)
    public String logout(){
        //退出
        //return "redirect:http://localhost:8080/cas/logout";
        // 退出登录后，跳转到退出成功的页面，不走默认页面
        return "redirect:http://SERVER/logout?service=http://CLIENT:9001/";
    }
 
    @RequestMapping(value="403")
    public String unAuth(){
        return "403";
    }
 
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
 
   @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
 
}