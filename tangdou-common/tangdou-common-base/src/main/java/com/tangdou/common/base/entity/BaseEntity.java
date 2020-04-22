package com.tangdou.common.base.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/15 23:47
 * @Description: 基础字段
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @ApiModelProperty("主键")
    @Id
    private String id;
}
