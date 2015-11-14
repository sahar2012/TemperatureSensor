package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor
{
	private TemperatureLog temperatureLog = new TemperatureLog(35,"Delhi");
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void register(Observer observer)
	{
		observers.add(observer);
	}
	
	public TemperatureLog getLogs()
	{
		return this.temperatureLog;
	}
	
	public void setLog(String City)
	{
		temperatureLog.setCity(City);
		Random randomGenerator = new Random();
		double randomTemp = randomGenerator.nextDouble();
		temperatureLog.setTemperature(randomTemp);
		notifyObservers();
	}
	
	public void notifyObservers()
	{
		for(Observer observer : observers)
		{
			observer.update();
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
