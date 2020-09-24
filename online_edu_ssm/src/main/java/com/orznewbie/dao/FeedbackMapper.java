package com.orznewbie.dao;

import com.orznewbie.entity.Feedback;

import java.util.List;

public interface FeedbackMapper {
    int insert(Feedback feedback);

    List<Feedback> queryAll();
}
