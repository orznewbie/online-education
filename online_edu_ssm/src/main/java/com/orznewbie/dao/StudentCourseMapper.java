package com.orznewbie.dao;

import com.orznewbie.entity.StudentCourse;

import java.util.List;

public interface StudentCourseMapper {
    List<StudentCourse> queryAll(String sid);

    int insert(StudentCourse studentCourse);
}
