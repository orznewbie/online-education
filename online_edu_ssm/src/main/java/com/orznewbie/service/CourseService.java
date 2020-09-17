package com.orznewbie.service;

import com.orznewbie.entity.Course;

import java.util.List;

public interface CourseService {
    Course query(Integer id);

    int delete(Integer id);

    int insert(Course course);

    int update(Course course);

    List<Course> getAll();
}
