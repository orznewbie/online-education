package com.orznewbie.service;

import com.orznewbie.entity.Video;

import java.util.List;

public interface VideoService {
    int insert(Video video);

    int delete(Integer id);

    int update(Video video);

    List<Video> queryAll();

    List<Video> query(Integer chid);
}
