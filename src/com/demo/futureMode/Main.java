package com.demo.futureMode;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		FutureClient fc = new FutureClient();
		Data data = fc.request("�������");
		System.out.println("�����ͳɹ�");
		System.out.println("����������");
		
		String result = data.getRequest();
		System.out.println(result);
	}
}
