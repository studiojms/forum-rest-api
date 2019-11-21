package com.studiojms.forum.service;

import com.studiojms.forum.domain.Course;
import com.studiojms.forum.repository.ICourseRepository;
import com.studiojms.forum.to.CourseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private ICourseRepository courseRepository;

	public Course convertToDomain(CourseTO courseTO) {
		Course course = null;

		if (courseTO.getId() != null) {
			course = courseRepository.findById(courseTO.getId()).orElse(null);
		}
		else if (courseTO.getName() != null && !courseTO.getName().isEmpty()) {
			course = courseRepository.findByName(courseTO.getName());
		}

		return course;
	}

}
