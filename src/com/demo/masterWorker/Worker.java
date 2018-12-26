package com.demo.masterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
	
			private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
		
	//master的任务队列
	public void setTaskQueue( ConcurrentLinkedQueue<Task> taskQueue)	{
		this.taskQueue = taskQueue;
	}
	
	//master存放worker执行后的结果集
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap){
		this.resultMap = resultMap;
	}
			
			@Override
		public void run() {
			//当任务队列不为空时，从Queue中取出任务进行处理
		    while(!taskQueue.isEmpty()){
		    	Task task = taskQueue.poll();
		    	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	handle(task);
		    }
		}

		private void handle(Task task) {
			this.resultMap.put(task.getName(), task.getPrice());
		}

}
