package com.asiainfo.user.web.controller;

import com.asiainfo.user.domain.User;
import com.asiainfo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * 2020/4/9 15:38
 * creator dufy
 */
@RestController
public class UserRestApiController {
	@Autowired
	private UserService userService;

	@PostMapping("/user/save")
	public User saveUser(@RequestParam String name){
		User user = new User();
		user.setName(name);
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
