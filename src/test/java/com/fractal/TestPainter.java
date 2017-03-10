package com.fractal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;

import edu.uweo.javaintro.tools.Turtle;

import org.junit.runner.RunWith;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.fractal.Painter;
import com.util.Util;
import com.fractal.Complex;

@RunWith(Parameterized.class)
public class TestPainter {
	
	private double expectedX;
	private double t;
	private double r;
	private double expectedY;
	private Mandelbrot expectedM;
	private Painter painter;
	
	@Before
	public void initializer() {
		Mandelbrot man = new Mandelbrot(new Complex(Util.xValue(r,t),Util.yValue(r,t)));
		 painter = new Painter(man);
	}
	
	public TestPainter(double expectedX, double expectedY, double r,double t) {
		this.expectedX = expectedX;
		this.expectedY = expectedY;
		this.expectedM = new Mandelbrot(new Complex(expectedX,expectedY));
		this.r=r;
		this.t = t;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> input() {
		List<Object[]> testArray = new ArrayList<>();
		for ( double r=700;r>=0;r-=100) {
			for ( double t=0; t<=360 ;t+=45) { 
				double eX = r*Math.cos(t*Math.PI/180)/350;
				double eY = r*Math.sin(t*Math.PI/180)/300;
				
				Object[] testCase = { eX,r,eY,t };
				testArray.add(testCase);
			}
			
		}
		return testArray;
	}
	
	@Test
	public void testXValue() {
		assertEquals(expectedX, Util.xValue(painter.getR(),painter.getT()),0);
	}
	
	@Test
	public void testYValue() {
		assertEquals(expectedY, Util.yValue(painter.getR(),painter.getT()),0);
	}
	
//	@Test
//	public void testPaintPoint() {
//		assertEquals(expectedM.getColor(), painter.getColor() );
//	}
}
