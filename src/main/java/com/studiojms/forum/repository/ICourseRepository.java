package com.studiojms.forum.repository;

import com.studiojms.forum.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {

	Course findByName(String name);

}
