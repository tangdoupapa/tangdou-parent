package com.tangdou.common.base.util;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.result.DataResult;
import com.tangdou.common.base.result.Result;
import org.springframework.data.domain.Page;

import static com.tangdou.common.base.enums.GeneralResultCode.FAIL;
import static com.tangdou.common.base.enums.GeneralResultCode.SUCCESS;

public class ResultUtil {

    public static GeneralResultCode success() {
        return SUCCESS;
    }

    public static <T> Result<T> success(T data) {
        if (null != data && data instanceof Page) {
            return successPage((Page) data);
        } else {
            return successData(data);
        }
    }

    public static <T> Result<T> successData(T data) {
        return DataResult.<T>builder().data(data).success(SUCCESS.isSuccess()).code(SUCCESS.getCode()).msg(SUCCESS.getMsg()).build();
    }

    public static <T> Result<T> successPage(Page<T> page) {
        return null;
    }

    public static GeneralResultCode fail() {
        return FAIL;
    }

    public static Result fail(String msg) {
        return Result.builder().success(FAIL.isSuccess()).code(FAIL.getCode()).msg(FAIL.getMsg()).build();
    }

    public static Result fail(Integer code, String message) {
        return Result.builder().success(false).code(code).msg(message).build();
    }


}
