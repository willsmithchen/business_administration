package com.business.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnStatusEnum implements StatusCode {
    //登陆状态码
    USER_LOGIN_FAILURE(1001,"登陆失败"),
    USER_LOGIN_SUCCESS(1002,"登陆成功"),
    USER_REGISTER_FAILURE(1003,"注册失败"),
    USER_REGISTER_SUCCESS(1004,"注册成功"),
    USER_REGISTERED(1005,"用户已注册")
    ;
    private int code;
    private String message;
}
