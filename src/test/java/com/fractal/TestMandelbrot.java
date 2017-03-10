package com.fractal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestMandelbrot {
	
	private Color expectedColor;
	private Mandelbrot mandelbrot;
	private double real;
	private double complex;
	
	@Before
	public void initializer() {
		mandelbrot = new Mandelbrot(new Complex(real, complex));
	}
	
	public TestMandelbrot(double real, double complex, Color expectedColor) {
		this.real = real;
		this.complex = complex;
		this.expectedColor = expectedColor;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> input() {
		List<Object[]> testArray = new ArrayList<>();
		
		for ( int i= 1; i<5;i++) {
			for(int j=0; j<100; j++) {

				double real = 0;
				double complex = j/20*i;
				
				Complex Z = new Complex();
				Complex C = new Complex(real,complex);
				Color color = null;
				double absoluteNumber = C.abs();
				int n = 0;
				int maxIterations = 1000;
				
				while ( absoluteNumber <= 2 && n < maxIterations ) {
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
				
				Object[] obj = {real, complex, color};
				testArray.add(obj);
			}
		}
		return testArray;
		
	}
	
	@Test
	public void testGetColor() {
		assertEquals(expectedColor, mandelbrot.getColor());
	}
}
