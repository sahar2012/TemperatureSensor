package com.iiitd.ap.lab10;

public class TemperatureLog 
{
	private double temperature;
	private String city;
	
	public double getTemperature() 
	{
		return temperature;
	}

	public void setTemperature(double temperature) 
	{
		this.temperature = temperature;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public TemperatureLog(double temperature,String city)
	{
		this.temperature = temperature;
		this.city = city;
	}
}
