package com.tangdou.ihrm.company.application.controller;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.util.IdWorker;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.common.base.web.controller.BaseController;
import com.tangdou.ihrm.company.application.response.DeptAllResponse;
import com.tangdou.ihrm.company.dao.entities.Company;
import com.tangdou.ihrm.company.dao.entities.Department;
import com.tangdou.ihrm.company.service.CompanyService;
import com.tangdou.ihrm.company.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:01S
 */
@CrossOrigin
@Api(value = "部门管理", tags = "部门管理")
@RestController
@RequestMapping(value = "/company/department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "新增公司", notes = "新增公司")
    @PostMapping
    public GeneralResultCode save(@RequestBody Department department) {
        department.setId(idWorker.nextIdToString());
        department.setCompanyId(companyId);
        departmentService.save(department);
        return ResultUtil.success();
    }

    @ApiOperation(value = "更新公司", notes = "更新公司")
    @PutMapping
    public GeneralResultCode update(@RequestBody Department Department) {
        departmentService.save(Department);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除公司", notes = "删除公司")
    @DeleteMapping("/{id}")
    public GeneralResultCode delete(@PathVariable("id") String id) {
        departmentService.removeById(id);
        return ResultUtil.success();
    }

    @ApiOperation(value = "查询公司", notes = "查询公司")
    @GetMapping("/{id}")
    public Result<Department> findById(@PathVariable("id") String id) {
        return ResultUtil.successData(departmentService.getById(id));
    }

    @ApiOperation(value = "查询所有公司", notes = "查询所有公司")
    @GetMapping
    public Result<DeptAllResponse> findAll() {
        Company company = companyService.getById(companyId);
        List<Department> depts = departmentService.findAll(companyId);
        return ResultUtil.successData(new DeptAllResponse(company, depts));
    }

}
