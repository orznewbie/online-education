package com.orznewbie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Integer id;
    private String title;
    private String cover;
    private String intro;
    private float price;
    private Integer salecnt;
    private Integer status;
    private String tid;
    private String link;
}
