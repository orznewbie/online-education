package com.orznewbie.controller;

import com.orznewbie.entity.Course;
import com.orznewbie.entity.Verify;
import com.orznewbie.service.CourseService;
import com.orznewbie.service.VerifyService;
import com.orznewbie.utils.JsonResult;
import com.orznewbie.entity.User;
import com.orznewbie.service.UserService;
import com.orznewbie.constants.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 已登入用户公共请求接口
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private CourseService courseService;

    @PutMapping("/user/upduser")
    public JsonResult updateUser(User user) {
        int row = userService.update(user);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @PutMapping("/user/updp")
    public JsonResult updatePwd(String id, String oldpwd, String newpwd) {
        Verify verify = verifyService.query(id);
        if (!verify.getPwd().equals(oldpwd)) return JsonResult.returnJson(StatusCode.FAIL);
        verify.setPwd(newpwd);
        int row = verifyService.update(verify);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @PutMapping("/user/updcourse")
    public JsonResult updateCourse(Course course) {
        int row = courseService.update(course);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }
}