package com.tangdou.common.base.exception;

import com.tangdou.common.base.enums.GeneralResultCode;
import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private GeneralResultCode code = GeneralResultCode.SERVER_ERROR;

    public CommonException() {
    }

    public CommonException(GeneralResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode;
    }
}
