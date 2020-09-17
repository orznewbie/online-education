package com.orznewbie.service.Impl;

import com.orznewbie.dao.VerifyMapper;
import com.orznewbie.entity.Verify;
import com.orznewbie.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class VerifyServiceImpl implements VerifyService {
    @Autowired
    private VerifyMapper verifyMapper;

    public Verify query(String id) {
        return verifyMapper.query(id);
    }

    @Transactional
    public int delete(String id) {
        return verifyMapper.delete(id);
    }

    @Transactional
    public int insert(Verify verify) {
        return verifyMapper.insert(verify);
    }

    @Transactional
    public int update(Verify verify) {
        return verifyMapper.update(verify);
    }
}
