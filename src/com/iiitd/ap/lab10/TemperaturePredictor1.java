package com.iiitd.ap.lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TemperaturePredictor1 extends Observer
{
	public TemperaturePredictor1(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}

	@Override
	public void update(TemperatureLog temperatureLog) 
	{
		try 
		{
			FileReader file = new FileReader("src"+File.separator+"TemperatureLogsFile.txt");
			BufferedReader br = new BufferedReader(file);
			String line = br.readLine();
			while(l)
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
	}
}
