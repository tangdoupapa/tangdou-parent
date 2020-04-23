package com.tangdou.ihrm.system.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.ihrm.system.dao.entities.Permission;
import com.tangdou.ihrm.system.dao.repository.PermissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface PermissionService extends BaseService<PermissionRepository, Permission, String> {

}
