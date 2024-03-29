//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

public class TemperatureSensorDemo {

	public static void main(String[] args) throws InterruptedException {
		TemperatureSensor temperatureSensor = new TemperatureSensor();
		temperatureSensor.getDelhiTemp().add(35.0);
		temperatureSensor.getMumbaiTemp().add(35.0);
		temperatureSensor.getSrinagarTemp().add(35.0);
		
		new SerializeTemperature(temperatureSensor);
		new TemperaturePredictor1(temperatureSensor);
		new TemperaturePredictor2(temperatureSensor);
		new GenerateStats(temperatureSensor);
		
		temperatureSensor.getTemperatureLog();
		

	}

}
