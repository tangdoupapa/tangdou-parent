package com.tangdou.ihrm.company.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/14 21:54
 * @Description: //saas部门管理
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "co_department")
public class Department extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -9084332495284489553L;

    @ApiModelProperty("父级ID")
    private String pid;

    @ApiModelProperty("企业ID")
    private String companyId;

    @ApiModelProperty("部门名称")
    private String name;

    @ApiModelProperty("部门编码，同级部门不可重复")
    private String code;

    @ApiModelProperty("负责人ID")
    private String managerId;

    @ApiModelProperty("负责人名称")
    private String manager;

    @ApiModelProperty("介绍")
    private String introduce;

    @ApiModelProperty("创建时间")
    private Date createTime;
}





