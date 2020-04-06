package com.tangdou.ihrm.company.application.controller;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.IdWorker;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.ihrm.company.dao.entities.Company;
import com.tangdou.ihrm.company.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:01
 * @Description:
 */
@Api(value = "公司管理", tags = "公司管理")
@RestController("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "新增公司", notes = "新增公司")
    @PostMapping("/save")
    public GeneralResultCode save(@RequestBody Company company) {
        company.setId(idWorker.nextId());
        companyService.save(company);
        return ResultUtil.success();
    }

    @ApiOperation(value = "更新公司", notes = "更新公司")
    @PostMapping("/update")
    public GeneralResultCode update(@RequestBody Company company) {
        companyService.save(company);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除公司", notes = "删除公司")
    @GetMapping("/delete/{id}")
    public GeneralResultCode delete(@PathVariable("id") Long id) {
        companyService.delete(id);
        return ResultUtil.success();
    }

    @ApiOperation(value = "查询公司", notes = "查询公司")
    @GetMapping("/find/{id}")
    public Result<Company> findById(@PathVariable("id") Long id) {
        return ResultUtil.successData(companyService.findById(id));
    }

    @ApiOperation(value = "查询所有公司", notes = "查询所有公司")
    @GetMapping("/find/all")
    public Result<List<Company>> findAll() {
        return ResultUtil.successData(companyService.findAll());
    }

}
