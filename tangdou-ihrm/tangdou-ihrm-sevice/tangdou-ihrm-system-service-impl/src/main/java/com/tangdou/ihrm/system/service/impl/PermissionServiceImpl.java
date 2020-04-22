package com.tangdou.ihrm.system.service.impl;

import com.tangdou.common.base.service.impl.BaseServiceImpl;
import com.tangdou.ihrm.system.dao.entities.Permission;
import com.tangdou.ihrm.system.dao.repository.PermissionRepository;
import com.tangdou.ihrm.system.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:49
 * @Description: 权限管理service impl
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionRepository, Permission, String> implements PermissionService {

}
