package com.demo.contrainer;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronousQueueTest {
	public static void main(String[] args) {
		AtomicInteger i = new AtomicInteger(0);
		SynchronousQueue q = new  SynchronousQueue<Integer>();
		
		//������СΪ0���������������������������������ѣ����̱߳�������take����add��takeֱ���õ�add��Ԫ�أ�
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
