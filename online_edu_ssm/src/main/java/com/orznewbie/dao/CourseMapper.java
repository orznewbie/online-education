package com.orznewbie.dao;

import com.orznewbie.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseMapper {
    List<Course> query(Map<String, Object> map);

    int delete(Integer id);

    int insert(Course course);

    int update(Course course);

    List<Course> queryAll();
}
