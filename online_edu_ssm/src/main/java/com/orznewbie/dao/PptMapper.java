package com.orznewbie.dao;

import com.orznewbie.entity.Ppt;

import java.util.List;

public interface PptMapper {
    int insert(Ppt ppt);

    int delete(Integer id);

    int update(Ppt ppt);

    List<Ppt> queryAll();
}
