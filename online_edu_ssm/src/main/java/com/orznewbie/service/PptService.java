package com.orznewbie.service;

import com.orznewbie.entity.Ppt;

import java.util.List;

public interface PptService {
    int insert(Ppt ppt);

    int delete(Integer id);

    int update(Ppt ppt);

    List<Ppt> queryAll();
}
