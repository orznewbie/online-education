package com.orznewbie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ppt {
    private Integer id;
    private String title;
    private String url;
    private Integer cid;
}
