package com.orznewbie.service;

import com.orznewbie.entity.Account;

public interface AccountService {
    Account getAccount(String id);

    int deleteAccount(String id);

    int updateAccount(Account account);

    int addAccount(Account account);
}
