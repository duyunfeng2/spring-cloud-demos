package com.asiainfo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 2020/4/10 21:32
 * creator dufy
 */
@RestController
public class HystrixDemoController {
	private static final Random random = new Random();
	/**
	 * 当 {@link #helloWorld()} 方法调用超时或者失败时，fallbackMethod 方法 {@link #errorContent()} 就会作为替代返回
	 * @return
	 */
	@GetMapping("hello-world")
	@HystrixCommand(fallbackMethod = "errorContent",
			commandProperties = {
				@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
						value = "100")
			})
	public String helloWorld() throws InterruptedException {
		int value = random.nextInt(200);
		System.out.println("helloWorld() 方法准备睡眠 "+ value +" 毫秒.");
		Thread.sleep(value);
		return "hello,world";
	}

	public String errorContent(){
		return "Fault";
	}
}
