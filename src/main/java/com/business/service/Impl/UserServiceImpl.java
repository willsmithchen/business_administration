package com.business.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.business.entity.User;
import com.business.mapper.UserMapper;
import com.business.result.Outcome;
import com.business.result.ReturnStatusEnum;
import com.business.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

    @Override
    public Outcome login(String userName, String password) {
        int result = userMapper.login(userName, password);
        if (result > 0) {
            return Outcome.success(ReturnStatusEnum.USER_LOGIN_SUCCESS);
        }
        return Outcome.success(ReturnStatusEnum.USER_LOGIN_FAILURE);
    }

    @Override
    public Outcome register(String name, String sex, String address, String userName, String password) {
        User user = userMapper.getUserIsExists(name, sex, userName);
        if (ObjectUtils.isEmpty(user)) {
            user = new User();
            user.setName(name);
            user.setSex(sex);
            user.setAddress(address);
            user.setUserName(userName);
            user.setPassword(password);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            int insert = userMapper.insert(user);
            if (insert > 0) {
                return Outcome.success(ReturnStatusEnum.USER_REGISTER_SUCCESS);
            }
            return Outcome.success(ReturnStatusEnum.USER_REGISTER_FAILURE);
        }
        return Outcome.success(ReturnStatusEnum.USER_REGISTERED);
    }
}
