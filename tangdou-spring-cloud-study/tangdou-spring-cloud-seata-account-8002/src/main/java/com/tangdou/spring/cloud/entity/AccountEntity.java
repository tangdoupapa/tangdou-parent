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
@Table(name = "t_account")
public class AccountEntity extends BaseEntity {
    private String userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
