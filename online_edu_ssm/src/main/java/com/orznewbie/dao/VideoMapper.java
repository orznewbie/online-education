package com.orznewbie.dao;

import com.orznewbie.entity.Video;

import java.util.List;

public interface VideoMapper {
    int insert(Video video);

    int delete(Integer id);

    int update(Video video);

    List<Video> queryAll();

    List<Video> query(Integer chid);
}
