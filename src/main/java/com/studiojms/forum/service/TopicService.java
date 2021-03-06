package com.studiojms.forum.service;

import com.studiojms.forum.domain.Course;
import com.studiojms.forum.domain.Topic;
import com.studiojms.forum.domain.User;
import com.studiojms.forum.repository.ITopicRepository;
import com.studiojms.forum.to.TopicTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	public Page<Topic> list(Pageable pageable) {
		return topicRepository.findAll(pageable);
	}

	public Topic findById(Long id) {
		return topicRepository.findById(id).orElse(null);
	}

	public List<Topic> findByCourseNameLike(String courseName) {
		return topicRepository.findAllByCourseNameContaining(courseName);
	}

	public Page<Topic> findByCourseNameLike(String courseName, Pageable pageable) {
		return topicRepository.findAllByCourseNameContaining(courseName, pageable);
	}

	@Transactional
	public Topic create(TopicTO topicTO) {
		Topic topic = this.convertToDomain(topicTO);
		return topicRepository.save(topic);
	}

	@Transactional
	public Topic update(Long id, TopicTO topicTO) {
		final Topic existingRecord = this.findById(id);
		if (existingRecord == null) {
			throw new RuntimeException("Entity not found with id " + id);
		}
		Topic topic = this.convertToDomain(topicTO);
		topic.setId(id);
		return topicRepository.save(topic);
	}

	@Transactional
	public void delete(Long id) {
		topicRepository.deleteById(id);
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
