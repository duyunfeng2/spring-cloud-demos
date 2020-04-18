package com.asiainfo.user.service;


import com.asiainfo.user.domain.User;
import com.asiainfo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * 2020/4/9 16:12
 * creator dufy
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Collection<User> findAll() {
		return userRepository.findAll();
	}
}
