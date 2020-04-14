package com.tangdou.common.handle;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.exception.CommonException;
import com.tangdou.common.base.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public GeneralResultCode error(HttpServletRequest request, HttpServletResponse response,
                                   Exception e) throws IOException {
        e.printStackTrace();
        if (e.getClass() == CommonException.class) {
            CommonException ce = (CommonException) e;
            return ce.getCode();
        } else {
            return ResultUtil.fail();
        }
    }
}
