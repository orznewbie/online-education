package com.orznewbie.controller;

import com.orznewbie.common.Result;
import com.orznewbie.entity.Banner;
import com.orznewbie.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Xenia
 * 顶端横幅控制类
 */
@RestController
@RequestMapping("/banner")
@CrossOrigin
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/delete", method= RequestMethod.DELETE)
    public Result delete(Integer id) {
        int row = bannerService.delete(id);
        if (row != 1) return Result.fail();
        return Result.succ(null);
    }

    @RequestMapping(value = "/insert", method= RequestMethod.POST)
    public Result insert(Banner banner) {
        int row = bannerService.insert(banner);
        if (row != 1) return Result.fail();
        return Result.succ(null);
    }

    @RequestMapping(value = "/update", method= RequestMethod.PUT)
    public Result update(Banner banner) {
        int row = bannerService.update(banner);
        if (row > 1) return Result.fail();
        return Result.succ(null);
    }

    @RequestMapping(value = "/all", method= RequestMethod.GET)
    public Result getAll() {
        List<Banner> banners = bannerService.getAll();
        return Result.succ(banners);
    }
}
