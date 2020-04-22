package com.tangdou.ihrm.system.application.controller;

import com.tangdou.common.base.enums.GeneralResultCode;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.IdWorker;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.common.controller.BaseController;
import com.tangdou.ihrm.system.application.request.UserPageRequest;
import com.tangdou.ihrm.system.dao.entities.User;
import com.tangdou.ihrm.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 10:01S
 */
@CrossOrigin
@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping(value = "/sys")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private IdWorker idWorker;

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/user")
    public GeneralResultCode save(@RequestBody User user) {
        user.setId(idWorker.nextIdToString());
        user.setPassword("123456");
        user.setEnableState(1);
        user.setCompanyId(companyId);
        user.setCompanyName(companyName);
        userService.save(user);
        return ResultUtil.success();
    }

    @ApiOperation(value = "更新用户", notes = "更新用户")
    @PutMapping("/user/{id}")
    public GeneralResultCode update(@RequestBody User user) {
        userService.save(user);
        return ResultUtil.success();
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping("/user/{id}")
    public GeneralResultCode delete(@PathVariable("id") String id) {
        userService.delete(id);
        return ResultUtil.success();
    }

    @ApiOperation(value = "查询用户", notes = "查询用户")
    @GetMapping("/user/{id}")
    public Result<User> findById(@PathVariable("id") String id) {
        return ResultUtil.successData(userService.findById(id));
    }

    @ApiOperation(value = "查询所有用户", notes = "查询所有用户")
    @PostMapping("/user/all")
    public Result<User> findPage(@RequestBody UserPageRequest pageRequest) {
        pageRequest.setCompanyId(companyId);
        return ResultUtil.successPage(userService.findPage(pageRequest));
    }

}
