package com.orznewbie.service.Impl;

import com.orznewbie.entity.Course;
import com.orznewbie.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    public Course query(Integer id) {
        return null;
    }

    @Transactional
    public int delete(Integer id) {
        return 0;
    }

    @Transactional
    public int insert(Course course) {
        return 0;
    }

    @Transactional
    public int update(Course course) {
        return 0;
    }

    public List<Course> getAll() {
        return null;
    }
}
