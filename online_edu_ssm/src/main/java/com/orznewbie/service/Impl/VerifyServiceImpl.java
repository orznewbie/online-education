package com.orznewbie.service.Impl;

import com.orznewbie.dao.UserMapper;
import com.orznewbie.dao.VerifyMapper;
import com.orznewbie.entity.User;
import com.orznewbie.entity.Verify;
import com.orznewbie.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class VerifyServiceImpl implements VerifyService {
    @Autowired
    private VerifyMapper verifyMapper;
    @Autowired
    private UserMapper userMapper;

    public Verify query(String id) {
        return verifyMapper.query(id);
    }

    @Transactional
    public int delete(String id) {
        return verifyMapper.delete(id);
    }

    /**
     * 两个插入语句需要放在同一个事务中管理，否则会出现错误
     * @param verify
     * @return
     */
    @Transactional
    public boolean insert(Verify verify) {
        int row = verifyMapper.insert(verify);
        User user = new User();
        user.setId(verify.getId());
        System.out.println(user);
        int row2 = userMapper.insert(user);
        if (row == 1 && row2 == 1) return true;
        return false;
    }

    @Transactional
    public int update(Verify verify) {
        return verifyMapper.update(verify);
    }
}
