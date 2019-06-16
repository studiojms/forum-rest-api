package com.studiojms.forum.service;

import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.repository.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private ITopicRepository topicRepository;

    public List<Topic> list() {
        return topicRepository.findAll();
    }

    public List<Topic> findByCourseNameLike(String courseName) {
        return topicRepository.findAllByCourseNameContaining(courseName);
    }

}
