package com.demo.contrainer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueueTest {
	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger(0);
		SynchronousQueue q = new  SynchronousQueue<Integer>();
		
		//容量大小为0，生产者生产的数据立即被消费者消费（多线程必须先有take再有add，take直接拿到add的元素）
		new Thread ( () -> {
			while(true)
				try {
					System.out.println(q.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}).start();
		
		new Thread( () -> {
			while(true){
				q.add(i.incrementAndGet());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}
}
