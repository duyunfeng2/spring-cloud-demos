package com.asiainfo;

import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

import java.util.Random;

/**
 * 2020/4/10 22:31
 * creator dufy
 */
public class RxJavaDemo {
	public static void main(String[] args) {
		Random random = new Random();
		int value = random.nextInt(200);
		Single.just("Hello,World")
				.subscribeOn(Schedulers.immediate())
				.subscribe(new Observer <String>() {
					@Override
					public void onCompleted() {
						System.out.println("正常执行结束");
					}

					@Override
					public void onError(Throwable throwable) {
						System.out.println("执行消耗的时间: "+ value +" 毫秒");
						System.out.println("熔断保护");
					}

					@Override
					public void onNext(String s) {
						if(value > 100){
							throw new RuntimeException("Timeout!");
						}
						System.out.println("执行消耗的时间: "+ value +" 毫秒");
					}
				});
	}
}
