package com.tangdou.ihrm.system.dao.repository;


import com.tangdou.common.dao.BaseRepository;
import com.tangdou.ihrm.system.dao.entities.Permission;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/16 21:12
 * @Description: 访问资源管理DAO
 */
public interface PermissionRepository extends BaseRepository<Permission, String> {
    List<Permission> findByTypeAndPid(int type, String pid);
}
