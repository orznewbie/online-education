package com.orznewbie.service.Impl;

import com.orznewbie.dao.StudentCourseMapper;
import com.orznewbie.entity.StudentCourse;
import com.orznewbie.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Override
    public List<StudentCourse> queryAll(String sid) {
        return studentCourseMapper.queryAll(sid);
    }

    @Transactional
    public int insert(StudentCourse studentCourse) {
        return studentCourseMapper.insert(studentCourse);
    }
}
