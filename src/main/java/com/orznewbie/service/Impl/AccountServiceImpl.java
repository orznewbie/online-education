package com.orznewbie.service.Impl;

import com.orznewbie.dao.AccountMapper;
import com.orznewbie.entity.Account;
import com.orznewbie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public Account getAccount(String id) {
        return accountMapper.getAccount(id);
    }

    @Override
    public int deleteAccount(String id) {
        return accountMapper.deleteAccount(id);
    }

    @Override
    public int updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public int addAccount(Account account) {
        return accountMapper.addAccount(account);
    }
}
