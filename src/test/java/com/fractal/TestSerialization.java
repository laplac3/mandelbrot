package com.fractal;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;




public class TestSerialization {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		
		final List<Mandelbrot> mandelbrotsOut= new ArrayList<Mandelbrot>();
        FileOutputStream foo = new FileOutputStream("PaintersListTest.ser");
        ObjectOutputStream fOut = new ObjectOutputStream(foo);
       
        Mandelbrot mandelbrotOut = new Mandelbrot(new Complex());
        mandelbrotsOut.add(mandelbrotOut);
        fOut.writeObject(mandelbrotsOut);
        fOut.close();
        
		FileInputStream fis = new FileInputStream("PaintersListTest.ser");
        ObjectInputStream fin = new ObjectInputStream(fis); 

        // paint from ser file
        @SuppressWarnings("unchecked")   
		List<Mandelbrot> mandelbrotsIns = (List<Mandelbrot>) fin.readObject();
        fin.close();
        for ( Mandelbrot mandelbrotIn : mandelbrotsIns ) {
        	assertEquals(Color.BLACK,mandelbrotIn.getColor());

        } 
	}

}
