package com.tangdou.common.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/14 22:44
 * @Description:
 */
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected String companyId;
    protected String companyName;

    @ModelAttribute
    public void beforeController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.companyId = "1247058453822771200";
        this.companyName = "糖豆集团";
    }
}
