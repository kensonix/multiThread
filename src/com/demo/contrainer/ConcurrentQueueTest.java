package com.demo.contrainer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentQueueTest {
		public static void main(String[] args) throws InterruptedException {
			//有界阻塞队列
			 ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(3);
			 abq.add("1");
			 abq.add("2");
			 abq.add("3");
//			 java.lang.IllegalStateException: Queue full
//			 abq.add("4");
			 System.out.println(abq.stream().count());
			 
			 //无界阻塞队列
			 LinkedBlockingQueue<String>  lbq = new LinkedBlockingQueue<String> ();
			 lbq.add("a");
			 lbq.add("b");
			 lbq.add("c");
			 lbq.add("d");
			 System.out.println(lbq.poll());
			 System.out.println(lbq.take());
			 System.out.println(lbq.peek());
			 System.out.println(lbq.take());
			 
			 //乐观锁CAS（compare and swap）算法，性能较高
			 ConcurrentLinkedQueue<String> clq = new ConcurrentLinkedQueue<String>();
			 clq.offer("a");
			 clq.add("b");
			 
		}
}
