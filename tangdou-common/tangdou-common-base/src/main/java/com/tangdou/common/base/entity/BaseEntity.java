package com.tangdou.common.base.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/15 23:47
 * @Description: 基础字段
 */
@MappedSuperclass
@Data
public abstract class BaseEntity {

    @ApiModelProperty("主键")
    @Id
    private String id;
}
