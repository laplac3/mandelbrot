package com.fractal;

import java.awt.Color;

import edu.uweo.javaintro.tools.Turtle;

public class Painter {
	
	private final double r;
	private final double t;
	private final Turtle laplace;
	private final Color color;
	
	public Painter(double r,double t, Color color, Turtle laplace) {
		this.color = color;
		this.laplace = laplace;
		this.r = r;
		this.t = t;
	}
	

	public double getT() {
		return t;
	}


	public double getR() {
		return r;
	}

	public Color getColor() {
		return color;
	}

	public Turtle getLaplace() {
		return laplace;
	}

	public static double xValue(double r, double t) {
		return r*Math.cos(t*Math.PI/180)/350;
	}

	public static double yValue(double r, double t) {
		return r*Math.sin(t*Math.PI/180)/300;
	}
	
	public void paintPoint() {
		getLaplace().move(0, 150);
		getLaplace().switchTo( color );
		getLaplace().move(t, r);
		getLaplace().fillCircle(1);
	}
	
}
