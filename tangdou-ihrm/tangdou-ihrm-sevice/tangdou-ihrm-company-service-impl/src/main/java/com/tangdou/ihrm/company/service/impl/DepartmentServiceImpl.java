package com.tangdou.ihrm.company.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.ihrm.company.dao.entities.Department;
import com.tangdou.ihrm.company.dao.repository.DepartmentRepository;
import com.tangdou.ihrm.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 11:49
 * @Description: 部门管理serviceImpl
 */
@Service
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentRepository, Department, String> implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll(String companyId) {

        return departmentRepository.findAll(getSpec(companyId));
    }
}
