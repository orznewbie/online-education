package com.orznewbie.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orznewbie.utils.JsonResult;
import com.orznewbie.constants.StatusCode;
import com.orznewbie.utils.TokenUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Xenia
 * 自定义的拦截器
 */
@Component
public class TokenHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null) {
            if (TokenUtils.verifyToken(token)) return true;
        }
        // 向前端返回json错误信息
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(JsonResult.returnJson(StatusCode.OUTDATE));
        out.append(json);
        return false;
    }
}
