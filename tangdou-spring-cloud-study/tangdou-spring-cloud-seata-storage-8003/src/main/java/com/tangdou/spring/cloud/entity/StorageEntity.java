package com.tangdou.spring.cloud.entity;

import com.tangdou.common.base.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@ApiModel
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_storage")
public class StorageEntity extends BaseEntity {

    private String productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
