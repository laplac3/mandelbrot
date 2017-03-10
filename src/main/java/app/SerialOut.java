package app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.fractal.Complex;
import com.fractal.Mandelbrot;
import com.util.Util;


public class SerialOut {
 
	public static void main(String[] args) throws IOException {
        final List<Mandelbrot> mandelbrots = new ArrayList<Mandelbrot>();
        FileOutputStream f = new FileOutputStream("MandelbrotsList.ser");
        ObjectOutputStream fout = new ObjectOutputStream(f);
        
		for ( double r=700;r>=0;r-=1) {
			for ( double t=0; t<=360 ;t+=.1) { 
				Complex c = new Complex(Util.xValue(r,t), Util.yValue(r,t));
				Mandelbrot mandelbrot = new Mandelbrot( c );
				mandelbrots.add(mandelbrot);			
			}	
		}		
		fout.writeObject(mandelbrots);
		fout.close();
	}
}
