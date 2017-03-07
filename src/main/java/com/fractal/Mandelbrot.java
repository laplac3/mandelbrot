package com.fractal;

import java.awt.Color;
// use binary file over serialization.
public class Mandelbrot extends Complex {
	 
	private static int maxIterations = 1000;
	private Color color;
	
	public Mandelbrot (double real, double complex) {
		super(real,complex);
		color = returnColor();
	}
	
	public Mandelbrot() {
		super();
	}
	
	public Color getColor() {
		return this.color;
	}
	
	private Color returnColor() {
		int n =0;
		Complex Z = new Complex();
		Complex C = new Complex( getReal(), getComplex());
		double absoluteNumber = C.abs();
		Color color;
		
		while ( absoluteNumber <=2 && n < maxIterations ) {
			n++;
			Z = Z.squareComplex();
			Z = Z.addComplex(C);
			absoluteNumber = Z.abs();
		}


		if (absoluteNumber <= 2 && n == maxIterations )
			color = Color.BLACK;
		else if ( absoluteNumber > 2 && n< maxIterations && n>= .08 * maxIterations )
			color = Color.MAGENTA;
		else if (absoluteNumber > 2 && n< maxIterations*.08 && n>= .018 * maxIterations )
			color = Color.GREEN;
		else
			color = Color.BLACK;
		return color;
		
	}
}
