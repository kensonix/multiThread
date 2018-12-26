package com.demo.masterWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class Master {
		//1.�����������
		private ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
		//2.worker ��Map
		private Map<String, Thread> workers = new HashMap<String,Thread>();
		//3.���workerִ�к�Ľ����
		private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<String, Object>();
		
		//4.���캯��������worker����
		public Master(Worker worker,int count){
			worker.setResultMap(resultMap);
			worker.setTaskQueue(taskQueue);
			for(int i = 1;i <= count; i++){
				workers.put("worker" + i, new Thread(worker));
			}
		}
		
		//5.�ύ����
		public void submit(Task task){
			taskQueue.add(task);
		}
		
		//6.ִ������
		public void execute(){
			for(Map.Entry<String, Thread> t : workers.entrySet())
				t.getValue().start();
		}
		
		//7.�ж��Ƿ����е�worker��ִ������
		public boolean isComplemeted(){
			for(Map.Entry<String, Thread> t : workers.entrySet()){
				if(! t.getValue().getState().equals(Thread.State.TERMINATED) ){
					return false;
				}
			}
			return true;
		}
		
		//8.�ӽ������ͳ������
		public int getResult(){
			return resultMap.values().stream().collect(Collectors.summingInt(obj -> (int) obj));
		}
}
