package com.studiojms.forum.repository;

import com.studiojms.forum.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findAllByCourseNameContaining(String name);

	Page<Topic> findAllByCourseNameContaining(String name, Pageable pageable);

}
