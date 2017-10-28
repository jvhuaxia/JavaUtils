package com.jvhuaxia.utils;

public class SingleDemo {

	private static volatile SingleDemo instance;

	private SingleDemo() {
	}

	public static SingleDemo getInstance() {
		if (instance == null) {
			synchronized (SingleDemo.class) {
				if (instance == null) {
					instance = new SingleDemo();
				}
			}
		}
		return instance;
	}
}