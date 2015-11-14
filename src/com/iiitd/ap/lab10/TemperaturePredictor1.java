package com.iiitd.ap.lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TemperaturePredictor1 extends Observer
{	
	public TemperaturePredictor1(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}

	@Override
	synchronized public void update(TemperatureLog temperatureLog) 
	{
//			ArrayList<String> LogsList = new ArrayList<String>();
//			FileReader file = new FileReader("src"+File.separator+"TemperatureLogsFile.txt");
//			BufferedReader br = new BufferedReader(file);
//			String line;
//			while((line=br.readLine())!=null)
//			{
//				LogsList.add(line);
//			}
//			br.close();
//			file.close();
//			int listIndex=LogsList.size()-1;
//			int count=0;
//			double avg=0;
//			while(listIndex>=0 && count<5)
//			{
//				String[] args = LogsList.get(listIndex).split(" ");
//				double temperature = Double.parseDouble(args[3]);
//				if(args[2].equals(temperatureLog.getCity()))
//				{
//					avg+=temperature;
//					count++;
//				}
//				listIndex--;
//			}
//			avg=avg/count;
		
			double avg=0;
			int count=0;
			if (temperatureLog.getCity().equals("Delhi")) {
				for (int i=temperatureSensor.getDelhiTemp().size()-1;i>temperatureSensor.getDelhiTemp().size()-6 && i>=0;i--) {
					avg += temperatureLog.getTemperature();
					count++;
				}
				avg = avg/count;
			}
			else if (temperatureLog.getCity().equals("Mumbai")) {
				for (int i=temperatureSensor.getMumbaiTemp().size()-1;i>temperatureSensor.getMumbaiTemp().size()-6 && i>=0;i--) {
					avg += temperatureLog.getTemperature();
					count++;
				}
				avg = avg/count;
			}
			if (temperatureLog.getCity().equals("Srinagar")) {
				for (int i=temperatureSensor.getSrinagarTemp().size()-1;i>temperatureSensor.getSrinagarTemp().size()-6 && i>=0;i--) {
					avg += temperatureLog.getTemperature();
					count++;
				}
				avg = avg/count;
			}
			System.out.println("Java Predicted temperature for "+temperatureLog.getCity()+" - "+avg);	
		
	}
}
