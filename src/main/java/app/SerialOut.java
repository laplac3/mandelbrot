package app;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fractal.Mandelbrot;
import com.fractal.Painter;


public class SerialOut implements Serializable {
    
    public SerialOut() {
    	
    }
	/**
	 * 
	 */
	private static final long serialVersionUID = 8947459268316914805L;

	public static void main(String[] args) throws IOException {
		
        final List<StringPainter> stringPainters = new ArrayList<StringPainter>();

        
        FileOutputStream cLF = new FileOutputStream("PaintersList.ser");
        ObjectOutputStream cLFout = new ObjectOutputStream(cLF);


		for ( double r=700;r>=0;r-=1) {
			for ( double t=0; t<=360 ;t+=.1) { 
				SerialOut serialOut = new SerialOut();
				Mandelbrot mandelbrot = new Mandelbrot(Painter.xValue(r,t), Painter.yValue(r,t));
				String color = Integer.toString(mandelbrot.getColor().getRGB());
				StringPainter stringPainter = serialOut.new StringPainter(r, t, color);
				stringPainters.add(stringPainter);
				
			}	

		}
		
        // write the client objects to file
        cLFout.writeObject(stringPainters);
        cLFout.close();
		
        System.out.println("Finished writing to file");
	}
	
	public class StringPainter implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 995268911887032072L;
		private final double r;
		private final double t;
		private final String color;
		
		public StringPainter(double r, double t, String color ) {
			this.r = r;
			this.t = t;
			this.color = color;	
		}

		public double getR() {
			return r;
		}

		public double getT() {
			return t;
		}

		public Color getColor() {
			Color c = new Color(Integer.parseInt(color));
			return c;
		}

		@Override
		public String toString() {
			return "StringPainter [r=" + r + ", t=" + t + ", color=" + color + "]";
		}
		
		
		
	}
}
