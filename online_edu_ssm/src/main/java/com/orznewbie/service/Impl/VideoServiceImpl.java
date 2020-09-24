package com.orznewbie.service.Impl;

import com.orznewbie.dao.VideoMapper;
import com.orznewbie.entity.Video;
import com.orznewbie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;

    @Transactional
    public int insert(Video video) {
        return videoMapper.insert(video);
    }

    @Transactional
    public int delete(Integer id) {
        return videoMapper.delete(id);
    }

    @Transactional
    public int update(Video video) {
        return videoMapper.update(video);
    }

    public List<Video> queryAll() {
        return videoMapper.queryAll();
    }

    public List<Video> query(Integer chid) {
        return videoMapper.query(chid);
    }
}
