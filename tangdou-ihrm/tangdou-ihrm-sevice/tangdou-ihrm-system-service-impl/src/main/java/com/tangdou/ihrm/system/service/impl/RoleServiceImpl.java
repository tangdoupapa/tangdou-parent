package com.tangdou.ihrm.system.service.impl;

import com.tangdou.common.base.service.impl.BaseServiceImpl;
import com.tangdou.ihrm.system.dao.entities.Role;
import com.tangdou.ihrm.system.dao.repository.RoleRepository;
import com.tangdou.ihrm.system.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:49
 * @Description: 角色管理service impl
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleRepository, Role, String> implements RoleService {

}
