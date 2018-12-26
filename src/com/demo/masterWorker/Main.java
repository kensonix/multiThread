package com.demo.masterWorker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		//创建master
		Master master = new Master(new Worker(),10);
		
		//提交100个任务
		Random rand = new Random();
		for(int i = 0; i< 100;i ++){
			Task task = new Task();
			task.setId(i);
			task.setName("任务" + i);
			task.setPrice(rand.nextInt(1000));
			master.submit(task);
		}
		
		//执行任务
		master.execute();
		long curTime = System.currentTimeMillis();
		
		while(true){
			if(master.isComplemeted()){
				System.out.println("任务已经完成，结果为：" + master.getResult() + " ；耗时：" + (System.currentTimeMillis() - curTime) );
				break;
			}
		}
		
	}
}
