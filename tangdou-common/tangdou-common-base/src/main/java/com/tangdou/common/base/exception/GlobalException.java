package com.tangdou.common.base.exception;

import com.tangdou.common.base.enums.GeneralResultCode;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private GeneralResultCode code = GeneralResultCode.SERVER_ERROR;

    public GlobalException() {
    }

    public GlobalException(GeneralResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode;
    }
}
