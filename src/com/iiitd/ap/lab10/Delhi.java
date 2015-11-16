//@author - Nalin Gupta 2014065
//			Sahar Siddiqui 2014091

package com.iiitd.ap.lab10;

public class Delhi {
	private double Mean;
	private double Median;
	private double Max;
	private double Min;
	private double JavaPredictor;
	private double UserPredictor;
	
	public double getMean() {
		return Mean;
	}
	public void setMean(double mean) {
		Mean = mean;
	}
	public double getMedian() {
		return Median;
	}
	public void setMedian(double median) {
		Median = median;
	}
	public double getMax() {
		return Max;
	}
	public void setMax(double max) {
		Max = max;
	}
	public double getMin() {
		return Min;
	}
	public void setMin(double min) {
		Min = min;
	}
	public double getJavaPredictor() {
		return JavaPredictor;
	}
	public void setJavaPredictor(double javaPredictor) {
		JavaPredictor = javaPredictor;
	}
	public double getUserPredictor() {
		return UserPredictor;
	}
	public void setUserPredictor(double userPredictor) {
		UserPredictor = userPredictor;
	}
	
	public void print() {
		System.out.println("----------------------DELHI-----------------------\n");
		System.out.println("Java Predicted Value - "+ JavaPredictor);
		System.out.println("User Precited Value - "+UserPredictor);
		System.out.println("STATS");
		System.out.println("\tMean Temperature: " + Mean);
		System.out.println("\tMedian Temperature: " + Median);
		System.out.println("\tMax Temperature: "+Max);
		System.out.println("\tMin Temperature: "+Min);
		System.out.println("\n");
	}
}
