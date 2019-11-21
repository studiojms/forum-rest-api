package com.studiojms.forum.to;

import com.studiojms.forum.domain.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CourseTO {

	private Long id;

	private String name;

	public CourseTO(Course course) {
		this.id = course.getId();
		this.name = course.getName();
	}

	public static CourseTO create(Course course) {
		return new CourseTO(course);
	}

}
