package com.iiitd.ap.lab10;

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
				temperatureSensor.setLog("Delhi");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (id==2) {
			while (true) {
				temperatureSensor.setLog("Mumbai");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if (id==3) {
			while (true) {
				temperatureSensor.setLog("Srinagar");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
