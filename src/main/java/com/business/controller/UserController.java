package com.business.controller;


import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.business.entity.User;
import com.business.result.Outcome;
import com.business.result.ReturnStatusEnum;
import com.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api(tags = "用户管理")
@RequestMapping(value = "/user-manager")
@RestController
public class UserController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "查询用户", notes = "根据用户ID")
    @ApiImplicitParam(name = "id", value = "用户ID", dataTypeClass = Integer.class, required = true)
    @GetMapping(value = "/{id}")
    public Outcome<User> getUserById(@PathVariable int id) {
        return Outcome.success(userService.getUserById(id));
    }

    @ApiOperation(value = "密码登陆", notes = "账号密码登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "账号", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class)
    })
    @GetMapping(value = "/login")
    public Outcome login(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "password") String password) {
        return userService.login(userName, password);
    }

    @ApiOperation(value = "用户注册", notes = "用户注册平台")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名称", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "sex", value = "性别", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "name", value = "真实姓名", required = true, dataTypeClass = String.class)
    })
    @GetMapping(value = "/register")
    public Outcome register(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "password") String password,
                            @RequestParam(value = "sex") String sex,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "name") String name) {
        return userService.register(name, sex, address, userName, password);
    }

    @ApiOperation(value = "会话登陆", notes = "账号密码登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "账号", required = true, dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataTypeClass = String.class)
    })
    @GetMapping(value = "/do-login")
    public SaResult doLogin(@RequestParam(value = "userName") String userName,
                            @RequestParam(value = "password") String password) {
        Outcome login = userService.login(userName, password);
        if (login.getCode() == 1002) {
            StpUtil.login(1001);
            return SaResult.ok(ReturnStatusEnum.USER_REGISTER_SUCCESS.getMessage());
        }
        return SaResult.error(ReturnStatusEnum.USER_LOGIN_FAILURE.getMessage());
    }

}
