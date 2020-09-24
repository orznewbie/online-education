package com.orznewbie.utils;

import com.orznewbie.constants.StatusCode;
import lombok.Data;

/**
 * @author Xenia
 * Json数据统一返回形式
 */
@Data
public class JsonResult {
    private Integer code;
    private String msg;
    private Object data;

    public static JsonResult returnJson(StatusCode statusCode, Object data) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.code = statusCode.getCode();
        jsonResult.msg = statusCode.getMsg();
        jsonResult.data = data;
        return jsonResult;
    }

    public static JsonResult returnJson(StatusCode statusCode) {
        return JsonResult.returnJson(statusCode, null);
    }
}
