package com.studiojms.forum.controller;

import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.service.TopicService;
import com.studiojms.forum.to.TopicTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicRestController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<TopicTO> list(String course) {
        List<Topic> topics;
        if (course != null) {
            topics = topicService.findByCourseNameLike(course);
        } else {
            topics = topicService.list();
        }

        return TopicTO.create(topics);
    }
}

