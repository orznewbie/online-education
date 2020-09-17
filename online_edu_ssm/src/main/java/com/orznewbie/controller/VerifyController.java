package com.orznewbie.controller;

import com.orznewbie.common.Result;
import com.orznewbie.entity.Verify;
import com.orznewbie.service.VerifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xenia
 * 用户名和密码控制类
 */
@RestController
@RequestMapping("/verify")
public class VerifyController {
    @Autowired
    private VerifyService verifyService;

    /**
     * 检查用户id是否重复
     * @param id
     * @return
     */
    @RequestMapping(value = "/check", method= RequestMethod.GET)
    public Result checkId(String id) {
        Verify verify = verifyService.query(id);
        if (verify == null) return Result.fail();
        return Result.succ(null);
    }

    /**
     * 登入请求
     * @param id
     * @param pwd
     * @return
     */
    @RequestMapping(value = "/login", method= RequestMethod.POST)
    public Result login(String id, String pwd) {
        Verify verify = verifyService.query(id);
        if (!verify.getPwd().equals(pwd)) return Result.fail();
        return Result.succ(null);
    }

    /**
     * 注册请求
     * @param verify
     * @return
     */
    @RequestMapping(value = "/register", method= RequestMethod.POST)
    public Result register(Verify verify) {
        int row = verifyService.insert(verify);
        if (row != 1) return Result.fail();
        return Result.succ(null);
    }

    /**
     * 更新密码
     * @param verify
     * @return
     */
    @RequestMapping(value = "/update", method= RequestMethod.PUT)
    public Result updatePwd(Verify verify) {
        int row = verifyService.update(verify);
        if (row > 1) return Result.fail();
        return Result.succ(null);
    }
}
