package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class SpringCloudHystrixClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudHystrixClientApplication.class, args);
	}

}
