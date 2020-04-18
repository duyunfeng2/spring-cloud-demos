package com.asiainfo.user.web.controller;

import com.asiainfo.user.domain.User;
import com.asiainfo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * {@link UserService}
 * 2020/4/9 16:10
 * creator dufy
 */
@RestController
public class UserServiceProviderRestApiController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/save")
	public User saveUser(@RequestBody User user){
		if(userService.save(user)){
			return user;
		}else {
			return null;
		}
	}

	@GetMapping("/user/list")
	public Collection<User> list(){
		return userService.findAll();
	}
}
