package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Random;

public class TemperatureSensor
{
	//private TemperatureLog temperatureLog;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private ArrayList<Double> delhiTemp = new ArrayList<>();
	private ArrayList<Double> mumbaiTemp = new ArrayList<>();
	private ArrayList<Double> srinagarTemp = new ArrayList<>();
	
	public ArrayList<Double> getDelhiTemp() {
		return delhiTemp;
	}

	public void setDelhiTemp(ArrayList<Double> delhiTemp) {
		this.delhiTemp = delhiTemp;
	}

	public ArrayList<Double> getMumbaiTemp() {
		return mumbaiTemp;
	}

	public void setMumbaiTemp(ArrayList<Double> mumbaiTemp) {
		this.mumbaiTemp = mumbaiTemp;
	}

	public ArrayList<Double> getSrinagarTemp() {
		return srinagarTemp;
	}

	public void setSrinagarTemp(ArrayList<Double> srinagarTemp) {
		this.srinagarTemp = srinagarTemp;
	}

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
