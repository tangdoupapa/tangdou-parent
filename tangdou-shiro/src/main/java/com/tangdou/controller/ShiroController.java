package com.tangdou.controller;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.common.base.web.controller.BaseController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/7/9 10:57
 * @Description:
 */
@RestController
@Api(value = "shiro测试", tags = "shiro测试")
@RequestMapping("/shiro")
public class ShiroController extends BaseController {

    @GetMapping("/get")
    public GeneralResultCode shiro() {
        return ResultUtil.success();
    }
}
