package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor
{
	//private TemperatureLog temperatureLog;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void register(Observer observer)
	{
		observers.add(observer);
	}
	
//	public TemperatureLog getLogs()
//	{
//		return this.temperatureLog;
//	}
	
	public void setLog(String City)
	{
		//temperatureLog.setCity(City);
		Random randomGenerator = new Random();
		double rangeMin = 5;
		double rangeMax = 45;
		double randomTemp = rangeMin + (rangeMax - rangeMin) * randomGenerator.nextDouble();
		//temperatureLog.setTemperature(randomTemp);
		TemperatureLog temperatureLog = new TemperatureLog(randomTemp,City);
		notifyObservers(temperatureLog);
	}
	
	public void notifyObservers(TemperatureLog temperatureLog)
	{
		for(Observer observer : observers)
		{
			observer.update(temperatureLog);
		}
	}
	
	public void getTemperatureLog() {
		Thread delhiThread = new Thread(new TemperatureReader(this,1));
		Thread mumbaiThread = new Thread(new TemperatureReader(this,2));
		Thread srinagarThread = new Thread(new TemperatureReader(this,3));
		delhiThread.start();
		mumbaiThread.start();
		srinagarThread.start();
	}
	
}
