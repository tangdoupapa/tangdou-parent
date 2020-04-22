package com.tangdou.ihrm.company.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.ihrm.company.dao.entities.Department;
import com.tangdou.ihrm.company.dao.repository.DepartmentRepository;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:02
 * @Description: 部门管理service
 */
public interface DepartmentService extends BaseService<DepartmentRepository, Department, String> {

    List<Department> findAll(String companyId);
}
