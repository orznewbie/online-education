package com.orznewbie.service.Impl;

import com.orznewbie.dao.UserMapper;
import com.orznewbie.entity.User;
import com.orznewbie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> query(Map<String, Object> map) {
        return userMapper.query(map);
    }

    @Transactional
    public int delete(String id) { return userMapper.delete(id); }

    @Transactional
    public int update(User user) {
        return userMapper.update(user);
    }

    public List<User> queryAll() {
        return userMapper.queryAll();
    }
}
