package com.orznewbie.dao;

import com.orznewbie.entity.Verify;

import java.util.List;
import java.util.Map;

public interface VerifyMapper {
    Verify query(String id);

    int delete(String id);

    int insert(Verify verify);

    int update(Verify verify);
}
