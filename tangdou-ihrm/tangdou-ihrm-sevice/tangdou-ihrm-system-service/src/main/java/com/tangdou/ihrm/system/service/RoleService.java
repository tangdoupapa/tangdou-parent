package com.tangdou.ihrm.system.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.ihrm.system.dao.entities.Role;
import com.tangdou.ihrm.system.dao.repository.RoleRepository;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:02
 * @Description: 角色管理service
 */
public interface RoleService extends BaseService<RoleRepository, Role, String> {
}
