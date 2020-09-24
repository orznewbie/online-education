package com.orznewbie.service.Impl;

import com.orznewbie.dao.PptMapper;
import com.orznewbie.entity.Ppt;
import com.orznewbie.service.PptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PptServiceImpl implements PptService {
    @Autowired
    private PptMapper pptMapper;
    @Transactional
    public int insert(Ppt ppt) {
        return pptMapper.insert(ppt);
    }

    @Transactional
    public int delete(Integer id) {
        return pptMapper.delete(id);
    }

    @Transactional
    public int update(Ppt ppt) {
        return pptMapper.update(ppt);
    }

    public List<Ppt> queryAll() {
        return pptMapper.queryAll();
    }
}
