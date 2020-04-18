package com.asiainfo.user.service;

import com.asiainfo.user.domain.User;

import java.util.Collection;

/**
 * 2020/4/9 15:33
 * creator dufy
 */
public interface UserService {
	boolean save(User user);

	Collection<User> findAll();
}
