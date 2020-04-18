package com.asiainfo.demo;

import java.util.*;

/**
 * JAVA 版本的观察者模式
 * 2020/4/8 9:50
 * creator dufy
 * 南京
 */
public class ObserverDemo {
	public static void main(String[] args) {
		MyObservable observable = new MyObservable();
		// 增加订阅者
		observable.addObserver(new Observer() {
			@Override
			public void update(Observable o, Object value) {
				System.out.println(value);
			}
		});

		observable.setChanged();
		// 发布者来发布通知给订阅者，而订阅者是被动的收到提醒（这种是推的模式）
		observable.notifyObservers("hello");

		echoIterator();
	}

	// 这种是主动的获取消息，是拉的模式
	public static void echoIterator(){
		List<Integer> integerList = Arrays.asList(1,2,3,4,5);
		Iterator<Integer> iteratorList = integerList.iterator();
		while (iteratorList.hasNext()){
			System.out.println(iteratorList.next());
		}
	}

	public static class MyObservable extends Observable{
		public synchronized void setChanged() {
			super.setChanged();
		}
	}

	public void test(){

	}
}
