package com.orznewbie.service;

import com.orznewbie.entity.User;

import java.util.List;

public interface UserService {
    User query(String id);

    int delete(String id);

    int insert(User user);

    int update(User user);

    List<User> getAll();
}
