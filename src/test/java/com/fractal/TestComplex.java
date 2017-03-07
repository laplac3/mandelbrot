package com.fractal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class TestComplex {
	
	private double expectedReal;
	private double expectedComplex;
	private String expectedStr;
	private double expectedAbs;
	private Complex complexNumber;
	private Complex expectedAddComplexNumber;
	private Complex Z;
	private Complex expectedSquare;
	
	@Before
	public void initializer() {
		complexNumber = new Complex(expectedReal, expectedComplex);
	}
	
	public TestComplex( double expectedReal, double expectedComplex, String expectedStr, double expectedAbs, Complex expectedAddComplexNumber, Complex Z, Complex expectedSquare) {
		this.expectedReal =expectedReal;
		this.expectedComplex = expectedComplex;
		this.expectedStr = expectedStr;
		this.expectedAbs = expectedAbs;
		this.expectedAddComplexNumber = expectedAddComplexNumber;
		this.Z = Z;
		this.expectedSquare = expectedSquare;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> input() {
		List<Object[]> testArray = new ArrayList<>();
		for (int i=1; i<100; ++i ) {
			int num1 = (int) (Math.random()*2);
			int num2 = (int) (Math.random()*2);
			double real = Math.random()*10*Math.pow(-1,num1);
			double complex =  Math.random()*10*Math.pow(-1,num2);
			
			//expected toString test
			String str = real + "+" +complex+"i";
		
			//expected abs test
			double abs = Math.hypot(real, complex);
			
			//expected add complex test
			int num3 = (int) (Math.random()*2);
			int num4 = (int) (Math.random()*2);
			double re2 = Math.random()*10*Math.pow(-1,num3);
			double com2 =  Math.random()*10*Math.pow(-1,num4);
			Complex comZ = new Complex(re2,com2);
			Complex addComNum = new Complex(re2+real, com2+complex);
			
			//expected square test
			double squaredReal = real*real-complex*complex;
			double squaredComplex = 2*real*complex;
			Complex expectedSquare = new Complex(squaredReal,squaredComplex);
			
			Object[] testCase = {real, complex, str, abs, addComNum, comZ, expectedSquare};
			testArray.add( testCase );
			}
		return testArray;
	}
	
	@Test
	public void testToString() {
		assertEquals(this.expectedStr,complexNumber.toString());
	}
	
	@Test
	public void testAbs() {
		assertEquals(this.expectedAbs, this.complexNumber.abs(),0);
	}
	
	@Test
	public void testAddComplex() {
		assertEquals(this.expectedAddComplexNumber.getReal(), complexNumber.addComplex(this.Z).getReal(),0);
		assertEquals(this.expectedAddComplexNumber.getComplex(), complexNumber.addComplex(this.Z).getComplex(),0);
	}
	
	@Test
	public void testSquare() {
		assertEquals(this.expectedSquare.getReal(), complexNumber.squareComplex().getReal(),0);
		assertEquals(this.expectedSquare.getComplex(), complexNumber.squareComplex().getComplex(),0);
	}
	
}
