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
	public void update(TemperatureLog temperatureLog) 
	{
		try 
		{
			ArrayList<String> LogsList = new ArrayList<String>();
			FileReader file = new FileReader("src"+File.separator+"TemperatureLogsFile.txt");
			BufferedReader br = new BufferedReader(file);
			String line;
			while((line=br.readLine())!=null)
			{
				LogsList.add(line);
			}
			br.close();
			file.close();
			int listIndex=LogsList.size()-1;
			int count=0;
			double avg=0;
			while(listIndex>=0 && count<5)
			{
				String[] args = LogsList.get(listIndex).split(" ");
				double temperature = Double.parseDouble(args[3]);
				if(args[2].equals(temperatureLog.getCity()))
				{
					avg+=temperature;
					count++;
				}
				listIndex--;
			}
			avg=avg/count;
			System.out.println("Predicted temperature for "+temperatureLog.getCity()+" - "+avg);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
