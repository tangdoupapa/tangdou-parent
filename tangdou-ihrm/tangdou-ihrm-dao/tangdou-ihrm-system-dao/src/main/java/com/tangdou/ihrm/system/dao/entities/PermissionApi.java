package com.tangdou.ihrm.system.dao.entities;

import com.tangdou.common.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 */
@Entity
@Table(name = "pe_permission_api")
@Getter
@Setter
public class PermissionApi extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1803315043290784820L;
    /**
     * 链接
     */
    private String apiUrl;
    /**
     * 请求类型
     */
    private String apiMethod;
    /**
     * 权限等级，1为通用接口权限，2为需校验接口权限
     */
    private String apiLevel;
}
