package com.tangdou.common.base.entity;

import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@ApiModel
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "co_payment")
public class Payment extends BaseEntity implements Serializable {
    private String serial;
}