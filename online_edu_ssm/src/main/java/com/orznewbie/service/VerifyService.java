package com.orznewbie.service;

import com.orznewbie.entity.Verify;

import java.util.List;
import java.util.Map;

public interface VerifyService {
    Verify query(String id);

    int delete(String id);

    boolean insert(Verify verify);

    int update(Verify verify);
}
