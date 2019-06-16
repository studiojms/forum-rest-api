package com.studiojms.forum.repository;

import com.studiojms.forum.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITopicRepository extends JpaRepository<Topic, Long> {

    List<Topic> findAllByCourseNameContaining(String name);
}
