package com.iiitd.ap.lab10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TemperatureReader implements Runnable {
	
	TemperatureSensor temperatureSensor;
	int id;
	
	public TemperatureReader (TemperatureSensor temperatureSensor, int id) {
		this.temperatureSensor = temperatureSensor;
		this.id = id;
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
		
	}

}
