package com.fractal;

import java.awt.Color;

import edu.uweo.javaintro.tools.Turtle;

public class Painter {
	
	private double r;
	private double t;
	private Turtle laplace;
	private Color color;
	
	public Painter(double r,double t, Color color, Turtle laplace) {
		this.color = color;
		this.laplace = laplace;
		this.r = r;
		this.t = t;
	}
	
	public static void main(String[] args) {
		
		for ( double r=700;r>=0;r-=1) {
			for ( double t=0; t<=360 ;t+=.1) { 
				Turtle laplace = new Turtle();
				Mandelbrot mandelbrot = new Mandelbrot(xValue(r,t), yValue(r,t));
				Painter painter = new Painter(r, t, mandelbrot.getColor(), laplace );
				painter.paintPoint();
			}		
		}
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
