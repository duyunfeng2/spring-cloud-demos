package com.asiainfo.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 2020/4/8 11:34
 * creator dufy
 */
public class SpringEventListenerDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 1. 注册监听器, 只对 MyApplicationEvent 的事件感兴趣
		applicationContext.addApplicationListener(new ApplicationListener <MyApplicationEvent>() {
			// 3. 监听器得到事件
			@Override
			public void onApplicationEvent(MyApplicationEvent event) {
				System.out.println("接受到的事件："+ event.getSource() +" ; 获取 Spring 应用上下文："+event.getApplicationContext());
			}
		});

		applicationContext.refresh();
		// 2. 发布事件
		applicationContext.publishEvent(new MyApplicationEvent(applicationContext,"hello"));
		applicationContext.publishEvent(new MyApplicationEvent(applicationContext,1));
		applicationContext.publishEvent(new MyApplicationEvent(applicationContext,new Integer(100)));

		applicationContext.close();
	}

	public static class MyApplicationEvent extends ApplicationEvent{

		private ApplicationContext applicationContext;
		/**
		 * Create a new {@code ApplicationEvent}.
		 *
		 * @param source the object on which the event initially occurred or with
		 *               which the event is associated (never {@code null})
		 */
		public MyApplicationEvent(ApplicationContext applicationContext,Object source) {
			super(source);
			this.applicationContext = applicationContext;
		}

		public ApplicationContext getApplicationContext() {
			return applicationContext;
		}
	}
}
