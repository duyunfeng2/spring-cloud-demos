package com.asiainfo.user.service;

import com.asiainfo.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * 这里是个代理请求，将远程请求到我们的客户端里面去
 * 2020/4/9 17:01
 * creator dufy
 */
@Service
public class UserServiceProxy implements UserService {
	// 这里的服务 http://user-service-provider 名称是复制 user-service-provider 模块中的 application.properties 文件中的 spring.application.name
	private static final String PROVIDER_SERVER_URL_PREFIX = "http://user-service-provider";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public boolean save(User user) {
		User returnValue = restTemplate.postForObject(PROVIDER_SERVER_URL_PREFIX + "/user/save",user,User.class);
		return returnValue == null ? false : true;
	}

	@Override
	public Collection<User> findAll() {
		return restTemplate.getForObject(PROVIDER_SERVER_URL_PREFIX + "/user/list",Collection.class);
	}
}
