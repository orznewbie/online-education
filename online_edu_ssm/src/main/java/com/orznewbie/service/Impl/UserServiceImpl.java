package com.orznewbie.service.Impl;

import com.orznewbie.dao.UserMapper;
import com.orznewbie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserMapper {
    @Autowired
    private UserMapper userMapper;

    public User query(String id) {
        return userMapper.query(id);
    }

    @Transactional
    public int delete(String id) {
        return userMapper.delete(id);
    }

    @Transactional
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    public int update(User user) {
        return userMapper.update(user);
    }

    public List<User> getAll() {
        return userMapper.getAll();
    }
}
