package com.business.service;

import com.business.entity.User;
import com.business.result.Outcome;

public interface UserService {
    /**
     * 根据用户查询用户信息
     *
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 账号密码登陆
     *
     * @param userName
     * @param password
     * @return
     */
    Outcome login(String userName, String password);

    /**
     * 用户注册
     *
     * @param name
     * @param sex
     * @param address
     * @param userName
     * @param password
     * @return
     */
    Outcome register(String name, String sex, String address, String userName, String password);
}
