package com.orznewbie.service.Impl;

import com.orznewbie.dao.FeedbackMapper;
import com.orznewbie.entity.Feedback;
import com.orznewbie.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Transactional
    public int insert(Feedback feedback) {
        return feedbackMapper.insert(feedback);
    }

    public List<Feedback> queryAll() {
        return feedbackMapper.queryAll();
    }
}
