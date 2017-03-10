package app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.fractal.Mandelbrot;
import com.fractal.Painter;

public class DrawFromSerial {

	public static void main(String[] args) throws IOException, ClassNotFoundException {	
		FileInputStream fis = new FileInputStream("MandelbrotsList.ser");
        ObjectInputStream fin = new ObjectInputStream(fis);

        // read the Mandelbrots.
        @SuppressWarnings("unchecked")
		List<Mandelbrot> mandlebrots = (List<Mandelbrot>) fin.readObject();
        fin.close();
        for ( Mandelbrot mandelbrot : mandlebrots ) {
        	Painter painter = new Painter( mandelbrot);
        	painter.paintPoint();
        	
        }
	} 
}
