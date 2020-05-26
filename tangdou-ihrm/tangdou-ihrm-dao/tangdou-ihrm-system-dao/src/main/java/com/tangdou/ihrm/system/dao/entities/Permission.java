package com.tangdou.ihrm.system.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangdou.common.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@TableName(value = "pe_permission")
@Getter
@Setter
@NoArgsConstructor
public class Permission extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -4990810027542971546L;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限类型 1为菜单 2为功能 3为API
     */
    private Integer type;

    private String code;

    /**
     * 权限描述
     */
    private String description;

    private String pid;

    private Integer enVisible;

    public Permission(String name, Integer type, String code, String description) {
        this.name = name;
        this.type = type;
        this.code = code;
        this.description = description;
    }


}
