package com.orznewbie.dao;

import com.orznewbie.entity.User;

import java.util.List;

public interface UserMapper {
    User query(String id);

    int delete(String id);

    int insert(User user);

    int update(User user);

    List<User> getAll();
}
