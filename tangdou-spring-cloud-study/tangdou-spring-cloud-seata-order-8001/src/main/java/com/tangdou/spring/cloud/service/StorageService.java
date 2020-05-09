package com.tangdou.spring.cloud.service;


import com.tangdou.common.base.result.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "tangdou-spring-cloud-seata-storage")

public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    @GlobalTransactional
    Result decrease(@RequestParam("productId") String productId,
                    @RequestParam("count") Integer count);
}
