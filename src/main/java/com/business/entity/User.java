package com.business.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "用户")
@Data
@TableName(value = "t_user")
public class User implements Serializable {
    @ApiModelProperty(value = "用户ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    @ApiModelProperty(value = "用户名", example = "李三")
    private String name;
    @ApiModelProperty(value = "登陆名称")
    private String userName;
    @ApiModelProperty(value = "登陆密码")
    private String password;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "地址")
    private String address;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;
}
