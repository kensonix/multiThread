package com.demo;

public class MultiThread2 extends FooThread {
	public synchronized void subMethod(){
		while(i > 0){
			i--;
			System.out.println("subMethod: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		MultiThread2 mulThread = new MultiThread2();
		Thread t1 = new Thread(() -> {mulThread.fooMethod(); });
		Thread t2 = new Thread(() -> {mulThread.subMethod(); });
		t1.start();
		t2.start();
	}
}

class FooThread{
	static int i =10;
	public synchronized void fooMethod(){
//		while(i > 0){
			i --;
			System.out.println("fooMethod: " + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//	}
}