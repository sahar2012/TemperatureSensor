package com.iiitd.ap.lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateStats extends Observer
{
	public GenerateStats(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}
	
	public double getMeanTemp(ArrayList<Double> list)
	{
		double mean=0;
		for(int i=0;i<list.size();i++)
		{
			mean+=list.get(i);
		}
		mean=mean/list.size();
		return mean;
	}
	
	public double getMedianTemp(ArrayList<Double> list)
	{
		double median;
		int mid=list.size()/2;
		if((list.size())%2==1)
		{
			median=list.get(mid);
		}
		else
		{
			median = (list.get(mid-1)+list.get(mid))/2.0;
		}
		return median;
	}
	
	public double getMinTemp(ArrayList<Double> list)
	{
		return list.get(0);
	}
	
	public double getMaxTemp(ArrayList<Double> list)
	{
		int size=list.size();
		return list.get(size-1);
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
			ArrayList<Double> last100Records = new ArrayList<Double>();
			while(listIndex>=0 && count<100)
			{
				String[] args = LogsList.get(listIndex).split(" ");
				double temperature = Double.parseDouble(args[3]);
				if(args[2].equals(temperatureLog.getCity()))
				{
					last100Records.add(temperature);
				}
				listIndex--;
			}
			last100Records.sort(null);
			double mean = getMeanTemp(last100Records);
			double median = getMedianTemp(last100Records);
			double max = getMaxTemp(last100Records);
			double min = getMinTemp(last100Records);
			System.out.println("Stats for "+temperatureLog.getCity()+" :\n");
			System.out.println("\tMean Temperature : "+mean);
			System.out.println("\tMedian Temperature : "+median);
			System.out.println("\tMax Temperature : "+max);
			System.out.println("\tMin Temperature : "+min);
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
