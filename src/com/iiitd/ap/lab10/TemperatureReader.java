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
			while (true) {
				System.out.println("Enterted Delhi");
				temperatureSensor.setLog("Delhi");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (id==2) {
			while (true) {
				System.out.println("Enterted Mumbai");
				temperatureSensor.setLog("Mumbai");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (id==3) {
			while (true) {
				System.out.println("Entered Srinagar");
				temperatureSensor.setLog("Srinagar");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		latch.countDown();
		
	}

}
