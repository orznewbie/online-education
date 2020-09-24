package com.orznewbie.controller;

import com.orznewbie.entity.StudentCourse;
import com.orznewbie.service.StudentCourseService;
import com.orznewbie.utils.JsonResult;
import com.orznewbie.constants.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentCourseService studentCourseService;

    /**
     * 购买课程
     * @param sid
     * @param cid
     * @return
     */
    @PostMapping("/stu/buyc/{sid}/{cid}")
    public JsonResult buyCourse(@PathVariable String sid, @PathVariable Integer cid) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setSid(sid);
        studentCourse.setCid(cid);
        int row = studentCourseService.insert(studentCourse);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    /**
     * 查询学生自己的课程
     * @param sid
     * @return
     */
    @GetMapping("/stu/qcourse")
    public JsonResult queryMyCourse(String sid) {
        List<StudentCourse> res = studentCourseService.queryAll(sid);
        return JsonResult.returnJson(StatusCode.SUCC, res);
    }
}
