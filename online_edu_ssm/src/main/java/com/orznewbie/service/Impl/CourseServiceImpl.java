package com.orznewbie.service.Impl;

import com.orznewbie.dao.CourseMapper;
import com.orznewbie.entity.Course;
import com.orznewbie.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> query(Map<String, Object> map) {
        return courseMapper.query(map);
    }

    @Transactional
    public int delete(Integer id) {
        return courseMapper.delete(id);
    }

    @Transactional
    public int insert(Course course) {
        return courseMapper.insert(course);
    }

    @Transactional
    public int update(Course course) {
        return courseMapper.update(course);
    }

    public List<Course> queryAll() {
        return courseMapper.queryAll();
    }
}
