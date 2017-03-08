package app;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.fractal.Painter;

import app.SerialOut.StringPainter;
import edu.uweo.javaintro.tools.Turtle;

public class DrawFromSerial {

	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
       
		
		FileInputStream fis = new FileInputStream("PaintersList.ser");
        ObjectInputStream fin = new ObjectInputStream(fis);

        // read the clients
        @SuppressWarnings("unchecked")
		List<StringPainter> stringPainters = (List<StringPainter>) fin.readObject();
        fin.close();
        for ( StringPainter stringPainter : stringPainters ) {
        	Turtle laplace = new Turtle();
        	Painter painter = new Painter(stringPainter.getR(), stringPainter.getT(), stringPainter.getColor(), laplace );
        	painter.paintPoint();
        	
        }
	} 
}
