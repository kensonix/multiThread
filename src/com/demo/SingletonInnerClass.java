package com.demo;

public class SingletonInnerClass {
	private  static SingletonInnerClass single = new SingletonInnerClass();
	
	public static SingletonInnerClass getInstance(){
		return single;
	}
}
