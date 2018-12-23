package com.demo.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Master {
		//1.创建任务队列
		private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
		//2.worker 的Map
		private Map<String, Thread> workers = new HashMap<String,Thread>();
		//3.存放worker执行后的结果集
		private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
		
		//4.构造函数，创建worker队列
		public Master(Worker worker,int count){
			worker.setResultMap(resultMap);
			worker.setTaskQueue(taskQueue);
			for(int i = 1;i <= count; i++){
				workers.put("worker" + i, new Thread(worker));
			}
		}
		
		//5.提交任务
		public void submit(Task task){
			taskQueue.add(task);
		}
		
		//6.执行任务
		public void execute(){
			for(Map.Entry<String, Thread> t : workers.entrySet())
				t.getValue().start();
		}
		
		//7.判断是否所有的worker都执行完了
		public boolean isComplemeted(){
			for(Map.Entry<String, Thread> t : workers.entrySet()){
				if(! t.getValue().getState().equals(Thread.State.TERMINATED) ){
					return false;
				}
			}
			return true;
		}
		
		//8.从结果集中统计数据
		public int getResult(){
			return resultMap.values().stream().collect(Collectors.summingInt(obj -> (int) obj));
		}
}
