package com.orznewbie.service.Impl;

import com.orznewbie.dao.ChapterMapper;
import com.orznewbie.entity.Chapter;
import com.orznewbie.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Transactional
    public int insert(Chapter chapter) {
        return chapterMapper.insert(chapter);
    }

    @Transactional
    public int delete(Integer id) {
        return chapterMapper.delete(id);
    }

    @Transactional
    public int update(Chapter chapter) {
        return chapterMapper.update(chapter);
    }

    public List<Chapter> queryAll(Integer cid) {
        return chapterMapper.queryAll(cid);
    }
}
