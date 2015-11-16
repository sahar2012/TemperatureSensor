//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

public abstract class Observer 
{
	protected TemperatureSensor temperatureSensor;
	public abstract void update(TemperatureLog temperatureLog);
}
