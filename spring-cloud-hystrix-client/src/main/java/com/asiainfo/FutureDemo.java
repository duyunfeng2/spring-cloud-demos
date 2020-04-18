package com.asiainfo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 2020/4/10 22:19
 * creator dufy
 */
public class FutureDemo {
	public static void main(String[] args) {
		Random random = new Random();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(()->{
			int value = random.nextInt(200);
			System.out.println("执行消耗的时间: "+ value +" 毫秒");
			Thread.sleep(value);
			return "hello,world";
		});

		try {
			future.get(100, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println("超过100毫秒后，跳转到这里，即熔断后的执行方法里面。超时保护");
		}

		executorService.shutdown();
	}
}
