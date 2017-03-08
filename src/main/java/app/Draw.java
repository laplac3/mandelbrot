package app;

import com.fractal.Mandelbrot;
import com.fractal.Painter;

import edu.uweo.javaintro.tools.Turtle;

public class Draw {
	public static void main(String[] args) {		
		for ( double r=700;r>=0;r-=1) {
			for ( double t=0; t<=360 ;t+=.1) { 
				Turtle laplace = new Turtle();
				Mandelbrot mandelbrot = new Mandelbrot(Painter.xValue(r,t), Painter.yValue(r,t));
				Painter painter = new Painter(r, t, mandelbrot.getColor(), laplace );
				painter.paintPoint();
			}		
		}
	}
}
