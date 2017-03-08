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

import app.SerialOut;
import app.SerialOut.StringPainter;
import edu.uweo.javaintro.tools.Turtle;


public class TestSerialization {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		
		final List<StringPainter> stringPaintersIn = new ArrayList<StringPainter>();
        FileOutputStream foo = new FileOutputStream("PaintersListTest.ser");
        ObjectOutputStream fOut = new ObjectOutputStream(foo);
        
        SerialOut serialOut = new SerialOut();
		String color = Integer.toString(Color.GREEN.getRGB());
		StringPainter stringPainterGreen = serialOut.new StringPainter(0, 0, color);
		stringPaintersIn.add(stringPainterGreen);
        fOut.writeObject(stringPaintersIn);
        fOut.close();
        
		FileInputStream fis = new FileInputStream("PaintersListTest.ser");
        ObjectInputStream fin = new ObjectInputStream(fis); 

        // paint from ser file
        @SuppressWarnings("unchecked")   
		List<StringPainter> stringPaintersOut = (List<StringPainter>) fin.readObject();
        fin.close();
        for ( StringPainter stringPainter : stringPaintersOut ) {
        	assertEquals(Color.GREEN,stringPainter.getColor()); 

        } 
	}

}
