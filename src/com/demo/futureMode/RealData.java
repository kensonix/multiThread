package com.demo.futureMode;

public class RealData implements Data {
	private String result;
	public RealData(String queryStr){
		System.out.println("����" + queryStr + " ���в�ѯ�����Ǹ���ʱ�ܳ��Ĳ���");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("������ϣ���ȡ���");
		result = "ƨ����ʲô��û��";
	}
	
	@Override
	public String getRequest() {
		return result;
	}

}
