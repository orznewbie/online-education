package com.orznewbie.controller;

import com.orznewbie.entity.Banner;
import com.orznewbie.entity.Course;
import com.orznewbie.entity.User;
import com.orznewbie.entity.Video;
import com.orznewbie.service.BannerService;
import com.orznewbie.service.CourseService;
import com.orznewbie.service.UserService;
import com.orznewbie.service.VideoService;
import com.orznewbie.utils.JsonResult;
import com.orznewbie.constants.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Xenia
 * 只对管理员开放的接口
 */
@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private VideoService videoService;

    @DeleteMapping("/admin/deluser")
    public JsonResult deleteUser(String id) {
        int row = userService.delete(id);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @DeleteMapping("/admin/delbanner")
    public JsonResult deleteBanner(Integer id) {
        int row = bannerService.delete(id);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @PostMapping("/admin/insbanner")
    public JsonResult insertBanner(Banner banner) {
        int row = bannerService.insert(banner);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @PutMapping("/admin/updbanner")
    public JsonResult updateBanner(Banner banner) {
        int row = bannerService.update(banner);
        if (row != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @DeleteMapping("/admin/delcourse")
    public JsonResult delcourse(Integer id) {
        int row = courseService.delete(id);
        if (id != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    /**
     * 用户查询，能根据id，name，role来进行不同的查询
     * 这里用map存储查询标签，后面结合动态sql进行查询
     * @param map
     * @return
     */
    @GetMapping("/admin/quser")
    public JsonResult queryUser(@RequestParam Map<String, Object> map) {
        List<User> users = userService.query(map);
        return JsonResult.returnJson(StatusCode.SUCC, users);
    }

    @GetMapping("/admin/usercnt")
    public JsonResult queryUserCnt(@RequestParam Map<String, Object> map) {
        Integer cnt = userService.query(map).size();
        return JsonResult.returnJson(StatusCode.SUCC, cnt);
    }

    @PostMapping("/admin/inscourse")
    public JsonResult insertCourse(Course course) {
        int cnt = courseService.insert(course);
        if (cnt != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    @PostMapping("/admin/uploadv")
    public JsonResult insertVideo(Video video) {
        int cnt = videoService.insert(video);
        if (cnt != 1) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }
}
