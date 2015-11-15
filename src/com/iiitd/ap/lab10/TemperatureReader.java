package com.iiitd.ap.lab10;

import java.util.concurrent.CountDownLatch;

public class TemperatureReader implements Runnable {
	
	TemperatureSensor temperatureSensor;
	int id;
	private final CountDownLatch latch;
	
	public TemperatureReader (TemperatureSensor temperatureSensor, int id,CountDownLatch latch) {
		this.temperatureSensor = temperatureSensor;
		this.id = id;
		this.latch=latch;
	}

	@Override
	public void run() {
		if (id ==1) {
				//System.out.println("Enterted Delhi");
				temperatureSensor.setLog("Delhi");
		}
		else if (id==2) {
				//System.out.println("Enterted Mumbai");
				temperatureSensor.setLog("Mumbai");
		}
		else if (id==3) {
				//System.out.println("Entered Srinagar");
				temperatureSensor.setLog("Srinagar");
		}
		
		latch.countDown();
		
	}

}
