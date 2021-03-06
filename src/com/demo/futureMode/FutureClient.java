package com.demo.futureMode;

public class FutureClient {
	public Data request(final String queryStr){
		
		final FutureData futureData = new FutureData();
		
		new Thread(() -> {
			RealData realData = new RealData(queryStr);
			futureData.setRealData(realData);
		}).start();
		
		return futureData;
	}
}
