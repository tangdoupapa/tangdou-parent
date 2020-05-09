package com.tangdou.spring.cloud.controller;

import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.spring.cloud.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping(value = "decrease")
    public Result decrease(@RequestParam("userId") String userId,
                           @RequestParam("money") BigDecimal money) {
        accountService.decrease(userId, money);
        return ResultUtil.successMessage("账户余额扣减成功，哈哈哈");
    }
}
