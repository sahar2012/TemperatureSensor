//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

public class TemperaturePredictor2 extends Observer
{
	
	public TemperaturePredictor2(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}

	@Override
	synchronized public void update(TemperatureLog temperatureLog) 
	{
		double predictedVal=0;
		double tempVal = 0;
		int i,j;
		
		if(temperatureLog.getCity().equals("Delhi"))
		{
			if(temperatureSensor.getDelhiTemp().size()<=5)
			{
				for(i=0;i<temperatureSensor.getDelhiTemp().size();i++)
				{
					predictedVal+=temperatureSensor.getDelhiTemp().get(i);
				}
				predictedVal=predictedVal/temperatureSensor.getDelhiTemp().size();
			}
			else
			{	
				for(i=0;i<=temperatureSensor.getDelhiTemp().size()-5;i++)
				{
					tempVal = 0;
					for(j=i;j<i+5;j++)
					{
						tempVal += temperatureSensor.getDelhiTemp().get(j);
					}
					predictedVal += tempVal/5;
				}
				predictedVal = predictedVal/i;
			}
			temperatureSensor.getDelhi().setUserPredictor(predictedVal);
			//System.out.println("User Predicted temperature for "+temperatureLog.getCity()+" - "+predictedVal);
		}
		else if(temperatureLog.getCity().equals("Mumbai"))
		{
			if(temperatureSensor.getMumbaiTemp().size()<=5)
			{
				for(i=0;i<temperatureSensor.getMumbaiTemp().size();i++)
				{
					predictedVal+=temperatureSensor.getMumbaiTemp().get(i);
				}
				predictedVal=predictedVal/temperatureSensor.getMumbaiTemp().size();
			}
			else
			{	
				for(i=0;i<=temperatureSensor.getMumbaiTemp().size()-5;i++)
				{
					tempVal = 0;
					for(j=i;j<i+5;j++)
					{
						tempVal += temperatureSensor.getMumbaiTemp().get(j);
					}
					predictedVal += tempVal/5;
				}
				predictedVal = predictedVal/i;
			}
			temperatureSensor.getMumbai().setUserPredictor(predictedVal);
			//System.out.println("User Predicted temperature for "+temperatureLog.getCity()+" - "+predictedVal);
		}
		else if(temperatureLog.getCity().equals("Srinagar"))
		{
			if(temperatureSensor.getSrinagarTemp().size()<=5)
			{
				for(i=0;i<temperatureSensor.getSrinagarTemp().size();i++)
				{
					predictedVal+=temperatureSensor.getSrinagarTemp().get(i);
				}
				predictedVal=predictedVal/temperatureSensor.getSrinagarTemp().size();
			}
			else
			{	
				for(i=0;i<=temperatureSensor.getSrinagarTemp().size()-5;i++)
				{
					tempVal = 0;
					for(j=i;j<i+5;j++)
					{
						tempVal += temperatureSensor.getSrinagarTemp().get(j);
					}
					predictedVal += tempVal/5;
				}
				predictedVal = predictedVal/i;
			}
			temperatureSensor.getSrinagar().setUserPredictor(predictedVal);
			//System.out.println("User Predicted temperature for "+temperatureLog.getCity()+" - "+predictedVal);
		}
		
	}
}
