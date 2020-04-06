package com.tangdou.common.base.enums;

import com.alibaba.fastjson.annotation.JSONType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

/**
 * 基础操作返回码  1xxxx
 * 用户操作返回码  2xxxx
 * 企业操作返回码  3xxxx
 * 权限操作返回码
 * 系统类返回码    9xxxx
 */
@AllArgsConstructor
@JSONType(serializeEnumAsJavaBean = true)
public enum GeneralResultCode {
    //基础操作返回码
    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false, 10001, "操作失败"),

    //系统错误返回码
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    @ApiModelProperty("操作结果")
    boolean success;
    @ApiModelProperty("返回码")
    int code;
    @ApiModelProperty("返回信息")
    String msg;

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
