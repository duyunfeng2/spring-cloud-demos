package com.asiainfo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 2020/4/9 16:27
 * creator dufy
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceProviderBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceProviderBootstrap.class,args);
	}
}
