package com.orznewbie.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Xenia
 * Json返回数据的状态码，使用enum包装，便于管理
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusCode {
    SUCC(200, "成功"),
    FAIL(404, "失败"),
    OUTDATE(301, "登陆身份过期"),
    NORIGHT(400, "没有权限"),
    IDERROR(500, "用户名错误"),
    PWDERROR(501, "密码错误");
    private Integer code;
    private String msg;
}
