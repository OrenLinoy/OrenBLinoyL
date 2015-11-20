package com.myorg.javacourse;

public class MathManager {
	
	double radius = 50;
	final double pai = Math.PI;
	double hypotenuse = 50;
	double degree = Math.sin(Math.toRadians(30));

	public double q1() {
		return radius*radius*pai;
	}
	public double q2() {
		return degree*hypotenuse;
	}
	public float q3() {
		return (float) Math.pow(20, 13);
	}
	public String getResults() {
		String line1 = new String("Calculation 1: Area of circle with radius " + radius + " is: " + q1());
		String line2 = new String("Calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is: " + q2());
		String line3 = new String("Calculation 3: Power of 20 with exp of 13 is " + q3());
		String resultStr = line1 + "<br>" + line2 + "<br>" + line3;
		return resultStr;
	}
}
