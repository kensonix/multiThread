package com.demo.contrainer;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockedQueue {
	private LinkedList<Object> queque = new LinkedList();
	private final int min = 0;
	private final int max;
	private AtomicInteger count = new AtomicInteger(0);
	private Object lock = new Object();
	public BlockedQueue(int size){
		this.max = size;
	}
	//放入元素，当超过最大数量时，队列阻塞
	public void put(Object obj) throws InterruptedException{
		synchronized(lock){
			if(this.count.get() == max){
				lock.wait();
			}
			queque.add(obj);
			count.incrementAndGet();
			System.out.println("Thread :" + Thread.currentThread().getName() + " add element  " + obj);
			lock.notify();
		}
	}
	
	//取出元素，当元素数量为0的时候，队列阻塞
	public Object take() throws InterruptedException{
		Object res = null;
		synchronized(lock){
			if(this.count.get() == min){
				lock.wait();
			}
			res = queque.removeFirst();
			count.decrementAndGet();
			System.out.println("Thread :" + Thread.currentThread().getName() + " remove element  " + res);
			lock.notify();
		}
		return res;
	}
	
	public static void main(String[] args) throws InterruptedException {
		BlockedQueue bq = new BlockedQueue(5);
		Thread t1 = new Thread(() -> {
			try {
				bq.put("a");
				bq.put("b");
				bq.put("c");
				bq.put("d");
				bq.put("e");
				bq.put("f");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				try {
					bq.take();
					bq.take();
					bq.take();
					bq.take();
					bq.take();
					bq.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"t2") ;
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
	}
}
