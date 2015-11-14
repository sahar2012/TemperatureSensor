package com.iiitd.ap.lab10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTemperature extends Observer
{

	public SerializeTemperature(TemperatureSensor temperatureSensor)
	{
		this.temperatureSensor=temperatureSensor;
		this.temperatureSensor.register(this);
	}
	
	@Override
	public void update() 
	{
		try {
			FileOutputStream file = new FileOutputStream("src"+File.separator+"TemperatureLogsFile.txt");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.temperatureSensor.getLogs());
			out.close();
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
