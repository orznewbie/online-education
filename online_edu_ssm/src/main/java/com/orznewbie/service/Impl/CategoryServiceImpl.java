package com.orznewbie.service.Impl;

import com.orznewbie.dao.CategoryMapper;
import com.orznewbie.entity.Category;
import com.orznewbie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }
}
