package com.orznewbie.utils;

import com.orznewbie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TokenJson {
    private String access_token;
    private User user;
}
