//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

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
					avg += temperatureSensor.getDelhiTemp().get(i);
					count++;
				}
				avg = avg/count;
				temperatureSensor.getDelhi().setJavaPredictor(avg);
			}
			else if (temperatureLog.getCity().equals("Mumbai")) {
				for (int i=temperatureSensor.getMumbaiTemp().size()-1;i>temperatureSensor.getMumbaiTemp().size()-6 && i>=0;i--) {
					avg += temperatureSensor.getMumbaiTemp().get(i);
					count++;
				}
				avg = avg/count;
				temperatureSensor.getMumbai().setJavaPredictor(avg);
			}
			if (temperatureLog.getCity().equals("Srinagar")) {
				for (int i=temperatureSensor.getSrinagarTemp().size()-1;i>temperatureSensor.getSrinagarTemp().size()-6 && i>=0;i--) {
					avg += temperatureSensor.getSrinagarTemp().get(i);
					count++;
				}
				avg = avg/count;
				temperatureSensor.getSrinagar().setJavaPredictor(avg);
			}
			
			//System.out.println("Java Predicted temperature for "+temperatureLog.getCity()+" - "+avg);	
		
	}
}
