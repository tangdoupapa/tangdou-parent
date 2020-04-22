package com.tangdou.ihrm.system.dao.entities;

import com.tangdou.common.base.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IDEA
 * Author:xzengsf
 * Date:2018/3/22 10:24
 * Description: 菜单权限实体类
 */
@Entity
@Table(name = "pe_permission_menu")
@Getter
@Setter
public class  PermissionMenu extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1002411490113957485L;

    //展示图标
    private String menuIcon;

    //排序号
    private String menuOrder;
}
