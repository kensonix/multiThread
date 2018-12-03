package com.demo;

public class MultiThread3 extends Thread{
	private volatile boolean isRunning = true;
	public void setRunning(boolean flag){
		this.isRunning = flag;
	}
	
	public void run(){
		while(isRunning){
			System.out.println("111");
		}
		System.out.println("----stop");
	}
	
	public static void main(String[] args) throws InterruptedException {
		MultiThread3  t = new MultiThread3();
		t.start();
		Thread.sleep(3000);
		t.setRunning(false);
	}
}
