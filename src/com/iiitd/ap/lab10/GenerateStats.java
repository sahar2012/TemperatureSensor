package com.iiitd.ap.lab10;

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
	synchronized public void update(TemperatureLog temperatureLog) 
	{
			ArrayList<Double> last100Records = new ArrayList<Double>();
			if(temperatureLog.getCity().equals("Delhi"))
			{
				for(int i=temperatureSensor.getDelhiTemp().size()-1;i>temperatureSensor.getDelhiTemp().size()-100 && i>=0;i--)
				{
					last100Records.add(temperatureSensor.getDelhiTemp().get(i));
				}
				last100Records.sort(null);
				temperatureSensor.getDelhi().setMean(getMeanTemp(last100Records));
				temperatureSensor.getDelhi().setMedian(getMedianTemp(last100Records));
				temperatureSensor.getDelhi().setMax(getMaxTemp(last100Records));
				temperatureSensor.getDelhi().setMin(getMinTemp(last100Records));
			}
			else if(temperatureLog.getCity().equals("Mumbai"))
			{
				for(int i=temperatureSensor.getMumbaiTemp().size()-1;i>temperatureSensor.getMumbaiTemp().size()-100 && i>=0;i--)
				{
					last100Records.add(temperatureSensor.getMumbaiTemp().get(i));
				}
				last100Records.sort(null);
				temperatureSensor.getMumbai().setMean(getMeanTemp(last100Records));
				temperatureSensor.getMumbai().setMedian(getMedianTemp(last100Records));
				temperatureSensor.getMumbai().setMax(getMaxTemp(last100Records));
				temperatureSensor.getMumbai().setMin(getMinTemp(last100Records));
			}
			else if(temperatureLog.getCity().equals("Srinagar"))
			{
				for(int i=temperatureSensor.getSrinagarTemp().size()-1;i>temperatureSensor.getSrinagarTemp().size()-100 && i>=0;i--)
				{
					last100Records.add(temperatureSensor.getSrinagarTemp().get(i));
				}
				last100Records.sort(null);
				temperatureSensor.getSrinagar().setMean(getMeanTemp(last100Records));
				temperatureSensor.getSrinagar().setMedian(getMedianTemp(last100Records));
				temperatureSensor.getSrinagar().setMax(getMaxTemp(last100Records));
				temperatureSensor.getSrinagar().setMin(getMinTemp(last100Records));
			}
			
//			System.out.println("Stats for "+temperatureLog.getCity()+" :\n");
//			System.out.println("\tMean Temperature : "+mean);
//			System.out.println("\tMedian Temperature : "+median);
//			System.out.println("\tMax Temperature : "+max);
//			System.out.println("\tMin Temperature : "+min);
		
					
	}
}
