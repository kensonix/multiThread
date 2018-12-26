package com.demo.masterWorker;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		//����master
		Master master = new Master(new Worker(),10);
		
		//�ύ100������
		Random rand = new Random();
		for(int i = 0; i< 100;i ++){
			Task task = new Task();
			task.setId(i);
			task.setName("����" + i);
			task.setPrice(rand.nextInt(1000));
			master.submit(task);
		}
		
		//ִ������
		master.execute();
		long curTime = System.currentTimeMillis();
		
		while(true){
			if(master.isComplemeted()){
				System.out.println("�����Ѿ���ɣ����Ϊ��" + master.getResult() + " ����ʱ��" + (System.currentTimeMillis() - curTime) );
				break;
			}
		}
		
	}
}
