package com.orznewbie.service;

import com.orznewbie.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {
    List<Course> query(Map<String, Object> map);

    int delete(Integer id);

    int insert(Course course);

    int update(Course course);

    List<Course> queryAll();
}
