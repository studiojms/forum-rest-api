package com.studiojms.forum.service;

import com.studiojms.forum.domain.Course;
import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.domain.User;
import com.studiojms.forum.repository.ITopicRepository;
import com.studiojms.forum.to.TopicTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private ITopicRepository topicRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    public List<Topic> list() {
        return topicRepository.findAll();
    }

    public List<Topic> findByCourseNameLike(String courseName) {
        return topicRepository.findAllByCourseNameContaining(courseName);
    }

    public Topic create(TopicTO topicTO) {
        Topic topic = this.convertToDomain(topicTO);
        return topicRepository.save(topic);
    }

    public Topic convertToDomain(TopicTO topicTO) {
        Course course = courseService.convertToDomain(topicTO.getCourse());
        User user = userService.convertToDomain(topicTO.getUser());

        Topic topic = new Topic();
        topic.setTitle(topicTO.getTitle());
        topic.setMessage(topicTO.getMessage());
        topic.setCourse(course);
        topic.setUser(user);

        return topic;
    }
}
