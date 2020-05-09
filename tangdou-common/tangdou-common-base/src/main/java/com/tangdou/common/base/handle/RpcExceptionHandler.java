package com.tangdou.common.base.handle;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.exception.CommonException;
import com.tangdou.common.base.result.Result;
import io.seata.core.context.RootContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author linzf
 * @since 2019/12/27
 * 类描述： 用于处理程序调用发生异常的时候由于异常被处理以后无法触发事务，而进行的处理，使之可以正常的触发事务。
 */
@Aspect
@Component
public class RpcExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(RpcExceptionHandler.class);

    @AfterReturning(pointcut = "execution(* com.tangdou.*.service.*.*(..))", returning = "returnValue")
    public void doRecoveryActions(JoinPoint joinPoint, Object returnValue) throws Exception {
        Result result = (Result) returnValue;
        if ((ObjectUtil.isNotEmpty(result) && result.getCode() == 500) && StrUtil.isNotBlank(RootContext.getXID())) {
            throw new CommonException(GeneralResultCode.SERVER_ERROR);
        }
    }
}