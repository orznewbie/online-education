package com.orznewbie.dao;

import com.orznewbie.entity.Banner;

import java.util.List;

public interface BannerMapper {

    int delete(Integer id);

    int insert(Banner banner);

    int update(Banner banner);

    List<Banner> queryAll();
}
