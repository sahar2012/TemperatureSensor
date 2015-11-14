package com.iiitd.ap.lab10;

public class TemperatureSensorDemo {

	public static void main(String[] args) {
		TemperatureSensor temperatureSensor = new TemperatureSensor();
		
		new SerializeTemperature(temperatureSensor);
		
		temperatureSensor.getTemperatureLog();
		

	}

}
