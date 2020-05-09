package com.tangdou.spring.cloud.controller;

import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.spring.cloud.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping(value = "/decrease")
    public Result decrease(@RequestParam("productId") String productId,
                           @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return ResultUtil.successMessage("库存扣减成功，哈哈哈哈");
    }
}
