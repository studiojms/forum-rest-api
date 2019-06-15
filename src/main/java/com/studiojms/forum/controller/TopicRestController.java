package com.studiojms.forum.controller;

import com.studiojms.forum.domain.*;
import com.studiojms.forum.to.TopicTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TopicRestController {

    @RequestMapping("/topics")
    public List<TopicTO> list() {
        Category software = new Category(1L, "Software", new ArrayList<Subcategory>());
        Subcategory development = new Subcategory(1L, "Development", software);
        Course course = new Course(1L, "Java", development);
        User user = new User(1L, "John", "john@john.com", "123", new ArrayList<>());
        Topic topic = new Topic(1L, LocalDateTime.now(), "Problem 1", "Problem description", course, user, new ArrayList<>(), TopicStatus.NOT_ANSWERED);

        return TopicTO.create(Arrays.asList(topic, topic, topic));
    }
}

