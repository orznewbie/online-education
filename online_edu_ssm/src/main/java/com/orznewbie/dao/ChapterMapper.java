package com.orznewbie.dao;

import com.orznewbie.entity.Chapter;

import java.util.List;

public interface ChapterMapper {
    int insert(Chapter Chapter);

    int delete(Integer id);

    int update(Chapter chapter);

    List<Chapter> queryAll(Integer cid);
}
