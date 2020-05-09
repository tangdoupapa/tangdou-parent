package com.tangdou.spring.cloud.entity;

import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@ApiModel
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order")
public class OrderEntity extends BaseEntity {
    private String userId;
    private String productId;
    private Integer count;
    private BigDecimal money;
    private Integer status; //订单状态：0：创建中，1：已创建
}
