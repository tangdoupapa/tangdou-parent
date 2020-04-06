package com.tangdou.ihrm.company.dao.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "co_company")
@ApiModel
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    private static final long serialVersionUID = 594829320797158219L;
    @Id
    private Long id;

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