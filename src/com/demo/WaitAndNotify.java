package com.demo;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


public class WaitAndNotify {
	
	public static void main(String[] args) {
		 final ArrayList list = new ArrayList<>();
		Object lock = new Object();
		CountDownLatch countDownLatch = new CountDownLatch(1);
		
		Thread t1 = new Thread(() ->{
//			synchronized(lock){
				for(int i = 0; i < 10; i++){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					list.add("tt");
					if(list.size() == 5){
//						lock.notify();
						countDownLatch.countDown();
					}
					System.out.println("list数组添加第" + i +"个元素: " + list.get(i));
				}
//			}
		},"t1");
		
		Thread t2 = new Thread(() ->{
//			synchronized(lock){
//				while(list.size() != 5){
					try {
//						lock.wait();
						countDownLatch.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//				}
				System.out.println("当前线程以获取通知，结束线程");
				throw new RuntimeException();
				
//			}
			
		},"t2");
		
		t2.start();
		t1.start();
	}
}
