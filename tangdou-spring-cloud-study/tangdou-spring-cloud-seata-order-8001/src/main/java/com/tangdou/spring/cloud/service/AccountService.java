package com.tangdou.spring.cloud.service;


import com.tangdou.common.base.result.Result;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Component
@FeignClient(value = "tangdou-spring-cloud-seata-account")
public interface AccountService {

    @PostMapping("/account/decrease")
    Result decrease(@RequestParam("userId") String userId,
                    @RequestParam("money") BigDecimal money);
}
