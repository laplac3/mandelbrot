package app;

import com.fractal.Complex;
import com.fractal.Mandelbrot;
import com.fractal.Painter;
import com.util.Util;

public class Draw {
	public static void main(String[] args) {		
		for ( double r=700;r>=0;r-=1) {
			for ( double t=0; t<=360 ;t+=.1) { 
				Mandelbrot mandelbrot = new Mandelbrot(new Complex( Util.xValue(r,t), Util.yValue(r,t) ));
				Painter painter = new Painter( mandelbrot );
				painter.paintPoint();
			}		
		}
	}
}
