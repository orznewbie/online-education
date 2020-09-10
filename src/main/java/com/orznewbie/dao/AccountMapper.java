package com.orznewbie.dao;

import com.orznewbie.entity.Account;

public interface AccountMapper {

    Account getAccount(String id);

    int deleteAccount(String id);

    int updateAccount(Account account);

    int addAccount(Account account);
}
