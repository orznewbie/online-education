package com.orznewbie.dao;

import com.orznewbie.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> query(Map<String, Object> map);

    int delete(String id);

    int insert(User user);

    int update(User user);

    List<User> queryAll();
}
