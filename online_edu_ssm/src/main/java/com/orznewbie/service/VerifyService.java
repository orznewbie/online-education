package com.orznewbie.service;

import com.orznewbie.entity.Verify;

public interface VerifyService {
    Verify query(String id);

    int delete(String id);

    int insert(Verify verify);

    int update(Verify verify);
}
