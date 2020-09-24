package com.orznewbie.controller;

import com.orznewbie.constants.StatusCode;
import com.orznewbie.entity.*;
import com.orznewbie.service.*;
import com.orznewbie.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xenia
 * 无需登入即可访问的接口
 */
@RestController
public class CommonController {
    @Autowired
    private BannerService bannerService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private UserService userService;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/common/allbanner")
    public JsonResult queryAllBanner() {
        List<Banner> banners = bannerService.queryAll();
        return JsonResult.returnJson(StatusCode.SUCC, banners);
    }

    @GetMapping("/common/topcourse")
    public JsonResult queryTop8Course() {
        Map<String, Object> map = new HashMap<>();
        map.put("ordered", "salecntDesc");
        map.put("startIndex", 0);
        map.put("offset", 8);
        List<Course> courses = courseService.query(map);
        return JsonResult.returnJson(StatusCode.SUCC, courses);
    }

    @GetMapping("/common/coursecnt")
    public JsonResult queryCourseCnt(@RequestParam Map<String, Object> map) {
        Integer cnt = courseService.query(map).size();
        return JsonResult.returnJson(StatusCode.SUCC, cnt);
    }

    @GetMapping("/common/qcourse")
    public JsonResult queryCourse(@RequestParam Map<String, Object> map) {
        List<Course> courses = courseService.query(map);
        return JsonResult.returnJson(StatusCode.SUCC, courses);
    }

    @GetMapping("/common/qchapter")
    public JsonResult queryChapter(Integer cid) {
        List<Chapter> chapters = chapterService.queryAll(cid);
        return JsonResult.returnJson(StatusCode.SUCC, chapters);
    }

    @GetMapping("/common/qvideo")
    public JsonResult queryVideo(Integer chid) {
        List<Video> videos = videoService.query(chid);
        return JsonResult.returnJson(StatusCode.SUCC, videos);
    }
    /**
     * 用户登入请求
     * @param id
     * @param pwd
     * @return token和用户信息
     */
    @PostMapping("/common/login")
    public JsonResult login(String id, String pwd) {
        Verify verify = verifyService.query(id);
        if (verify == null) return JsonResult.returnJson(StatusCode.IDERROR);
        if (!verify.getPwd().equals(pwd)) return JsonResult.returnJson(StatusCode.PWDERROR);
        // 1. 根据id从user表中查询出用户信息
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<User> users = userService.query(map);
        // 2. 生成token
        String access_token = TokenUtils.generateToken(users.get(0).getId(), users.get(0).getRole());
        // 3. 返回json数据
        return JsonResult.returnJson(StatusCode.SUCC, new TokenJson(access_token, users.get(0)));
    }

    @PostMapping("/common/register")
    public JsonResult register(Verify verify) {
        boolean ok = verifyService.insert(verify);
        if (!ok) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    /**
     * 查询用户id是否存在
     * @param id
     * @return
     */
    @GetMapping("/common/checkid")
    public JsonResult checkId(String id) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<User> users = userService.query(map);
        if (users.size() != 0) return JsonResult.returnJson(StatusCode.FAIL);
        return JsonResult.returnJson(StatusCode.SUCC);
    }

    /**
     * 查询某个课程下的所有章节和章节下的所有视频
     * @param cid
     * @return
     */
    @GetMapping("/common/allcv")
    public JsonResult queryAllCourseVideo(Integer cid) {
        List<Chapter> chapterList = chapterService.queryAll(cid);
        List<List<Video>> videoList = new ArrayList<>();
        for (Chapter chapter : chapterList) {
            videoList.add(videoService.query(chapter.getId()));
        }
        return JsonResult.returnJson(StatusCode.SUCC, new CourseVideoJson(chapterList, videoList));
    }

    /**
     * 查询所有课程种类
     * @return
     */
    @GetMapping("/common/ccat")
    public JsonResult queryCourseCategory() {
        List<Category> categoryList = categoryService.queryAll();
        return JsonResult.returnJson(StatusCode.SUCC, categoryList);
    }
}
