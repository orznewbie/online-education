package com.orznewbie.service;

import com.orznewbie.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    int insert(Feedback feedback);

    List<Feedback> queryAll();
}
