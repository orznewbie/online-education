package com.orznewbie.service;

import com.orznewbie.entity.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    List<StudentCourse> queryAll(String sid);

    int insert(StudentCourse studentCourse);
}
