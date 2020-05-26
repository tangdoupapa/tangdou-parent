package com.tangdou.ihrm.company.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;


/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/14 21:54
 * @Description: saas企业管理
 */
@TableName(value = "co_company")
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;

    @ApiModelProperty("公司名称")
    private String name;

    @ApiModelProperty("企业登录账号ID")
    private String managerId;

    @ApiModelProperty("当前版本")
    private String version;

    @ApiModelProperty("续期时间")
    private Date renewalDate;

    @ApiModelProperty("到期时间")
    private Date expirationDate;

    @ApiModelProperty("公司地区")
    private String companyArea;

    @ApiModelProperty("公司地址")
    private String companyAddress;

    @ApiModelProperty("营业执照-图片ID")
    private String businessLicenseId;

    @ApiModelProperty("法人代表")
    private String legalRepresentative;

    @ApiModelProperty("公司电话")
    private String companyPhone;

    @ApiModelProperty("邮箱")
    private String mailbox;

    @ApiModelProperty("公司规模")
    private String companySize;

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("审核状态")
    private String auditState;

    @ApiModelProperty("状态")
    private Integer state;

    @ApiModelProperty("当前余额")
    private Double balance;

    @ApiModelProperty("创建时间")
    private Date createTime;
}
