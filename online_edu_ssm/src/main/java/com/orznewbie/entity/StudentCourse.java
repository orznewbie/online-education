package com.orznewbie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourse {
    private Integer id;
    private String sid;
    private Integer cid;
    private float cost;
}
