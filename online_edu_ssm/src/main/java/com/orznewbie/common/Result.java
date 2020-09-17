package com.orznewbie.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xenia
 * Json数据统一返回形式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    // 状态码，202表示成功，303表示失败
    private Integer code;
    // 状态信息
    private String msg;
    // json数据
    private Object data;

    public static Result succ(Object data) {
        Result res = new Result(202, "成功", data);
        return res;
    }

    public static Result fail() {
        Result res = new Result(303, "失败", null);
        return res;
    }

}
