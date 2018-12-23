package com.demo.masterWorker;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Worker implements Runnable{
	private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
	
			private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
		
	//master���������
	public void setTaskQueue( ConcurrentLinkedQueue<Task> taskQueue)	{
		this.taskQueue = taskQueue;
	}
	
	//master���workerִ�к�Ľ����
	public void setResultMap(ConcurrentHashMap<String, Object> resultMap){
		this.resultMap = resultMap;
	}
			
			@Override
		public void run() {
			//��������в�Ϊ��ʱ����Queue��ȡ��������д���
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
