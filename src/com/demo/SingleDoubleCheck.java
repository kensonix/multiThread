package com.demo;

public class SingleDoubleCheck {
	private static SingleDoubleCheck instance;
	private static Object lock = new Object();
	
	public static SingleDoubleCheck getInstance(){
		if(instance == null){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(lock){
				if(instance == null){
					instance = new SingleDoubleCheck();
				}
			}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": " + SingleDoubleCheck.getInstance().hashCode() );
		},"t1");
		
		Thread t2 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": " + SingleDoubleCheck.getInstance().hashCode() );
		},"t2");
		
		Thread t3 = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + ": " + SingleDoubleCheck.getInstance().hashCode() );
		},"t3");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
