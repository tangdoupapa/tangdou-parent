package com.tangdou.ihrm.system.application.controller;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.common.base.web.controller.BaseController;
import com.tangdou.common.util.IdWorker;
import com.tangdou.ihrm.system.application.request.RolePageRequest;
import com.tangdou.ihrm.system.dao.entities.Role;
import com.tangdou.ihrm.system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:01S
 */
@CrossOrigin
@Api(value = "角色管理", tags = "角色管理")
@RestController
@RequestMapping(value = "/sys")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "新增角色", notes = "新增角色")
    @PostMapping("/role")
    public GeneralResultCode save(@RequestBody Role role) {
        role.setId(idWorker.nextIdToString());
        role.setCompanyId(companyId);
        roleService.save(role);
        return ResultUtil.success();
    }

    @ApiOperation(value = "更新角色", notes = "更新角色")
    @PutMapping("/role/{id}")
    public GeneralResultCode update(@RequestBody Role role) {
        roleService.save(role);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除角色", notes = "删除角色")
    @DeleteMapping("/role/{id}")
    public GeneralResultCode delete(@PathVariable("id") String id) {
        roleService.removeById(id);
        return ResultUtil.success();
    }

    @ApiOperation(value = "查询角色", notes = "查询角色")
    @GetMapping("/role/{id}")
    public Result<Role> findById(@PathVariable("id") String id) {
        return ResultUtil.successData(roleService.getById(id));
    }

    /*@ApiOperation(value = "分页查询角色", notes = "分页查询角色")
    @PostMapping("/role/page")
    public Result<Role> findPage(@RequestBody RolePageRequest pageRequest) {
        pageRequest.setCompanyId(companyId);
        return ResultUtil.successPage(roleService.findPage(pageRequest));
    }*/


}
