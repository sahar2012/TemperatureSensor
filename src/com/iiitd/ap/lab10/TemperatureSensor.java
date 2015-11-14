package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor implements Runnable
{
	private TemperatureLog temperatureLog = new TemperatureLog(35,"Delhi");
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	int id;
	
	public TemperatureSensor (int id) {
		this.id = id;
	}
	
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

	@Override
	public void run() {
		if (id ==1) {
			setLog("Delhi");			
		}
		else if (id==2) {
			setLog("Mumbai");
		}
		else if (id==3) {
			setLog("Srinagar");
		}
		
	}
	
}
