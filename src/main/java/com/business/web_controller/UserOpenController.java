package com.business.web_controller;

import com.business.entity.User;
import com.business.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "外部用户管理")
@RestController
@RequestMapping(value = "/open-user")
public class UserOpenController {
    @Resource
    private UserService userService;

    @ApiOperation(value = "查询用户")
    @GetMapping(value = "/{id}")
    public User getOpenUserById(@PathVariable @ApiParam(value = "用户ID") int id){
        return userService.getUserById(id);
    }
}
