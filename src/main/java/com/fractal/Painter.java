package com.fractal;

import java.awt.Color;

import com.util.Util;

import edu.uweo.javaintro.tools.Turtle;

public class Painter {
	
	private final double r;
	private final double t;
	private final Color color;
	
	Turtle laplace = new Turtle();
	
	public Painter(double r,double t, Color color) {
		this.color = color;
		this.r = r;
		this.t = t;
	}
	
	public Painter(Mandelbrot mandelbrot ) {
		Complex mComplex = mandelbrot.getMComplex();
		double x = mComplex.getReal();
		double y = mComplex.getComplex();
		this.color = mandelbrot.getColor();
		this.r = Util.rValue(x, y);
		this.t = Util.tValue(x, y);
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
	
	public void paintPoint() {
		laplace.move(0, 150);
		laplace.switchTo( color );
		laplace.move(t, r);
		laplace.fillCircle(1);
	}
	
}
