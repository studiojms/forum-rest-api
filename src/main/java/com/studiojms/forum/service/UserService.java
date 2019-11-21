package com.studiojms.forum.service;

import com.studiojms.forum.domain.User;
import com.studiojms.forum.repository.IUserRepository;
import com.studiojms.forum.to.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;

	public User convertToDomain(UserTO userTO) {
		User user = null;

		if (userTO.getId() != null) {
			user = userRepository.findById(userTO.getId()).orElse(null);
		}
		else if (userTO.getName() != null && !userTO.getName().isEmpty()) {
			user = userRepository.findByName(userTO.getName());
		}

		return user;
	}

}
