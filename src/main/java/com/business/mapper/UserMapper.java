package com.business.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.business.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 账号密码登陆
     *
     * @param userName
     * @param password
     * @return
     */
    int login(@Param(value = "userName") String userName,
              @Param(value = "password") String password);

    /**
     * 查询用户是否已存在
     * @param name
     * @param sex
     * @param userName
     * @return
     */
    User getUserIsExists(@Param(value = "name") String name,
                         @Param(value = "sex") String sex,
                         @Param(value = "userName") String userName);
}
