package com.orznewbie.service.Impl;

import com.orznewbie.dao.BannerMapper;
import com.orznewbie.entity.Banner;
import com.orznewbie.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Transactional
    public int delete(Integer id) {
        return bannerMapper.delete(id);
    }

    @Transactional
    public int insert(Banner banner) {
        return bannerMapper.insert(banner);
    }

    @Transactional
    public int update(Banner banner) {
        return bannerMapper.update(banner);
    }

    public List<Banner> getAll() {
        return bannerMapper.getAll();
    }
}
