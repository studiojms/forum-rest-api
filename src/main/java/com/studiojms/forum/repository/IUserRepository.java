package com.studiojms.forum.repository;

import com.studiojms.forum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

	User findByName(String name);

}
