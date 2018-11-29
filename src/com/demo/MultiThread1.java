package com.demo;
//dirtyRead Ôà¶ÁÀý×Ó
public class MultiThread1 {
	private  String userName ="aa";
	private   String passWord ="aa";
	public  synchronized void SetValue(String name,String pwd){
		this.userName = name;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.passWord = pwd;
		System.out.println("setVal:userName: " + userName + ";passWord:" + passWord);
	}
	
	public  synchronized void getValue(){
		System.out.println("getVal:userName: " + userName + ";passWord:" + passWord);
	}
	
	public static void main(String[] args) throws InterruptedException {
		MultiThread1 obj = new MultiThread1();
		Thread t1 = new Thread( () -> obj.SetValue("bb","bb"));
		t1.start();
		Thread.sleep(1000);
		obj.getValue();
	}
	
}
