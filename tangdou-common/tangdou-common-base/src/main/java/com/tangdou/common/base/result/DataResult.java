package com.tangdou.common.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@ApiModel("统一结果返回")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class DataResult<T> extends Result<T> {

    @ApiModelProperty("返回携带数据")
    private T data;

}
