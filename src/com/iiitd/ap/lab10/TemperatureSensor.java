//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class TemperatureSensor
{
	//private TemperatureLog temperatureLog;
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private ArrayList<Double> delhiTemp = new ArrayList<>();
	private ArrayList<Double> mumbaiTemp = new ArrayList<>();
	private ArrayList<Double> srinagarTemp = new ArrayList<>();
	private Delhi delhi = new Delhi();
	private Mumbai mumbai = new Mumbai();
	private Srinagar srinagar = new Srinagar();
	
	public Delhi getDelhi() {
		return delhi;
	}

	public void setDelhi(Delhi delhi) {
		this.delhi = delhi;
	}

	public Mumbai getMumbai() {
		return mumbai;
	}

	public void setMumbai(Mumbai mumbai) {
		this.mumbai = mumbai;
	}

	public Srinagar getSrinagar() {
		return srinagar;
	}

	public void setSrinagar(Srinagar srinagar) {
		this.srinagar = srinagar;
	}

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
		//Random randomGenerator = new Random();
		UserRandom randomGenerator = new UserRandom();
		double rangeMin = 5;
		double rangeMax = 45;
		double randomTemp = rangeMin + (rangeMax + rangeMin) * randomGenerator.nextVal();
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
	
	public void printToConsole () {
		delhi.print();
		mumbai.print();
		srinagar.print();
		
	}
	
	public void getTemperatureLog() throws InterruptedException {
		final CountDownLatch latch = new CountDownLatch(3);
		while (true) {
			Thread delhiThread = new Thread(new TemperatureReader(this,1,latch));
			Thread mumbaiThread = new Thread(new TemperatureReader(this,2,latch));
			Thread srinagarThread = new Thread(new TemperatureReader(this,3,latch));
			delhiThread.start();
			mumbaiThread.start();
			srinagarThread.start();
			delhiThread.join();
			mumbaiThread.join();
			srinagarThread.join();
			printToConsole();
			Thread.sleep(5000);
		}
//		try {
//			latch.await();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
