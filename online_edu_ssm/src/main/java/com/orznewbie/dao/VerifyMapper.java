package com.orznewbie.dao;

import com.orznewbie.entity.Verify;

public interface VerifyMapper {
    Verify query(String id);

    int delete(String id);

    int insert(Verify verify);

    int update(Verify verify);
}
