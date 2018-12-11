package com.demo.contrainer;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
	class DelayEle implements Delayed{
		public long delayTime;
		public String name;
		public DelayEle (int delayTime, String name){
			this.delayTime = System.currentTimeMillis() + delayTime;
			this.name = name;
		}

		public int compareTo(Delayed o) {
			return this.delayTime  - ((DelayEle)o).delayTime >  0 ? 1 :  this.delayTime  - ((DelayEle)o).delayTime < 0  ? -1 :0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
//			System.out.println("222");
			long cur = System.currentTimeMillis();
//			System.out.println(this.delayTime+ "-----" +System.currentTimeMillis());
			return unit.convert(this.delayTime  - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
		}
		public String toString(){
			return this.name;
		}
	}
	public static void main(String[] args) throws InterruptedException {
		DelayQueueTest t = new DelayQueueTest();
		//这里第一个参数是在多少毫秒才能被取出
		DelayEle ele1 = t.new DelayEle(1000,"t1");
		DelayEle ele2 = t.new DelayEle(5000,"t2");
		DelayEle ele3 = t.new DelayEle(3000,"t3");
		
		DelayQueue dq = new DelayQueue();
		dq.add(ele1);
		dq.add(ele2);
		dq.add(ele3);
		
		while(dq.size() > 0){
//			System.out.println(111);
			System.out.println(dq.take());
		}
	}
	
	
}
