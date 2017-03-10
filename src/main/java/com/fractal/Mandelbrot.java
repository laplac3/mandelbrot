package com.fractal;

import java.awt.Color;
import java.io.Serializable;


public class Mandelbrot extends Complex implements Serializable {
	 

	@Override
	public String toString() {
		return "Mandelbrot [color=" + color + ", complex=" + complex + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5622012588737880341L;
	private static final int maxIterations = 1000;
	private final Color color;
	private final Complex complex;
	
	public Mandelbrot (Complex complex) {
		this.complex = complex;
		color = returnColor();
	}
	
	public Mandelbrot() {
		this.complex = new Complex();
		color = Color.BLACK;
	}
	
	public Complex getMComplex() {
		return this.complex;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	private Color returnColor() {
		int n =0;
		Complex Z = new Complex();
		Complex C = complex;
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

