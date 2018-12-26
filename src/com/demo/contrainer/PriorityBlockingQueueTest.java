package com.demo.contrainer;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {
	
	 class PriorityEle implements Comparable<PriorityEle>{
		private int id;
		private String name;
		public PriorityEle(int id,String name){
			this.id = id;
			this.name = name;
		}
		
		public int compareTo(PriorityEle o) {
			return this.id > o.id ? 1 : (this.id <o.id)?  -1: 0;
		}
		public String toString(){
			return this.name;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		PriorityBlockingQueueTest t = new PriorityBlockingQueueTest();
		PriorityEle ele1 =  t.new PriorityEle(5,"t1");
		PriorityEle ele2 =  t.new PriorityEle(1,"t2");
		PriorityEle ele3 =  t.new PriorityEle(8,"t3");
		
		PriorityBlockingQueue<PriorityBlockingQueueTest.PriorityEle> pbq = new  PriorityBlockingQueue<PriorityBlockingQueueTest.PriorityEle>();
		pbq.add(ele1);
		pbq.add(ele2);
		pbq.add(ele3);
		
		System.out.println(pbq.take());
		System.out.println(pbq.take());
		System.out.println(pbq.take());
	}
}
