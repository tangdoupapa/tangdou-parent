package com.tangdou.common.base.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Payment)实体类
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@ApiModel
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "co_payment")
public class Payment extends BaseEntity implements Serializable {
    private String serial;
}
