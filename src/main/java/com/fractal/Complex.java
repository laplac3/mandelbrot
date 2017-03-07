package com.fractal;

public class Complex {
	
	private double real;
	private double complex;
	
	public Complex( double real, double complex ) {
		this.real = real;
		this.complex = complex;
	}
	
	public Complex() {
		this.real = (double)0;
		this.complex = (double)0;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getComplex() {
		return complex;
	}

	public void setComplex(double complex) {
		this.complex = complex;
	}
	
	public String toString() {
		return real + "+" + complex + "i";
	}
	
	public double abs() {
		return Math.hypot(real, complex);
	}
	
	public Complex addComplex( Complex Z ) {
		double re = this.real + Z.getReal();
		double com = this.complex + Z.getComplex();
		return new Complex( re , com);
	}
	
	public Complex squareComplex() {
		double re = this.real*this.real - this.complex*this.complex;
		double com = 2*this.real*this.complex;
		return new Complex(re,com);
	}
	
	
	
}
