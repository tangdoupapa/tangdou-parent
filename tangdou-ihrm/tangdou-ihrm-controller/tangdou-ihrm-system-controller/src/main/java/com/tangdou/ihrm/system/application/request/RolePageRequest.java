package com.tangdou.ihrm.system.application.request;

import com.tangdou.common.request.PagerRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/16 21:54
 * @Description:
 */
@ApiModel("用户搜索条件")
@Data
public class RolePageRequest extends PagerRequest {

    @ApiModelProperty("企业id")
    private String companyId;
}
