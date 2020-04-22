package com.tangdou.common.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@ApiModel("统一结果返回")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    @ApiModelProperty("是否成功")
    protected boolean success;

    @ApiModelProperty("返回状态码")
    protected Integer code;

    @ApiModelProperty("返回携带消息")
    protected String message;
}
