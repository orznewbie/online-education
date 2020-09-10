package com.orznewbie.controller;

import com.orznewbie.entity.Account;
import com.orznewbie.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/checkID/{id}", method = RequestMethod.GET)
    public String checkID(@PathVariable String id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return "true";
        }
        return "false";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String id, String pwd) {
        Account account = accountService.getAccount(id);
        if (account == null || !pwd.equals(account.getPwd())) {
            return "false";
        }
        return "true";
    }

}
