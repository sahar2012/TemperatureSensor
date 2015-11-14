package com.iiitd.ap.lab10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class SerializeTemperature extends Observer
{

	public SerializeTemperature(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}
	
	@Override
	synchronized public void update(TemperatureLog temperatureLog) {
		if (temperatureLog.getCity().equals("Delhi")) {
			temperatureSensor.getDelhiTemp().add(temperatureLog.getTemperature());
		}
		else if (temperatureLog.getCity().equals("Mumbai")) {
			temperatureSensor.getMumbaiTemp().add(temperatureLog.getTemperature());
		}
		else if (temperatureLog.getCity().equals("Srinagar")) {
			temperatureSensor.getSrinagarTemp().add(temperatureLog.getTemperature());
		}
		try {
			FileWriter file = new FileWriter("src"+File.separator+"TemperatureLogsFile.txt",true);
			BufferedWriter bw = new BufferedWriter(file);
			java.util.Date date= new java.util.Date();
			Timestamp time = new Timestamp(date.getTime());
			bw.write(time.toString());
			bw.write(" ");
			bw.write(temperatureLog.getCity());
			bw.write(" ");
			String temp = Double.toString(temperatureLog.getTemperature());
			bw.write(temp);
			bw.write("\n");
			bw.close();
			file.close();
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
