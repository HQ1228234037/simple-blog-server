package com.hq.simpleblog.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回状态码枚举类
 *
 * @author HQ
 * @since 2020/3/22 15:16
 **/
@AllArgsConstructor
@Getter
public enum Code {

    Success(1, "执行成功"),
    Error(0, "系统异常"),
    Failure(-1, "执行失败"),
    DataError(-2, "数据异常"),
    RequestParamError(-3, "请求参数异常"),
    LoginFailure(-4, "登录失败"),
    NotLogin(-5, "未登录"),
    AccessDenied(-6, "无权访问");

    private Integer code;
    private String message;

}
