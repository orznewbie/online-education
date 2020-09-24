package com.orznewbie.service;

import com.orznewbie.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> query(Map<String, Object> map);

    int delete(String id);

    int update(User user);

    List<User> queryAll();
}
