package com.demo.contrainer;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyAndWriteArrayListTest {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<String>();
		cowList.add("a");
		cowList.add("b");
		cowList.add("c");
		cowList.add("d");
		cowList.add("e");
		
		new Thread( () -> {
			while (cowList.size() > 0 ){
				System.out.println("1--------------------------");
				for(Object obj : cowList)
					System.out.println(obj);
				
				System.out.println("2--------------------------");
			}
		}).start();
		
		new Thread(() -> {
			while (cowList.size() > 0 ){
				cowList.remove(0);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			} ).start();
	
	
	}
}
