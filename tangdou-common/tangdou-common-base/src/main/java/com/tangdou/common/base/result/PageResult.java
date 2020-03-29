package com.tangdou.common.base.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@ApiModel("分页统一结果返回")
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class PageResult<T> extends Result<T> {
    @ApiModelProperty("总条数")
    private Long total;

    @ApiModelProperty("分页返回对象")
    private List<T> rows;

    @ApiModelProperty("第几页")
    private Integer pageNo;

    @ApiModelProperty("总页")
    private Integer pageSize;

}
