package com.orznewbie.service;

import com.orznewbie.entity.Banner;

import java.util.List;

public interface BannerService {

    int delete(Integer id);

    int insert(Banner banner);

    int update(Banner banner);

    List<Banner> getAll();
}
