package com.util;

public class Util {
	
	public static double xValue( final double r, final double t) {
		return r*Math.cos(t*Math.PI/180)/350;
	}

	public static double yValue(final double r, final double t) {
		return r*Math.sin(t*Math.PI/180)/300;
	}
	
	public static double tValue(final double x, final double y) {
		double t;
		//first quadrant
		if ( x > 0 && y > 0)
			t = Math.toDegrees(Math.atan((y)/(x) ));
		//second quadrant
		else if (x < 0 && y > 0 )
			t = Math.toDegrees( Math.PI  - Math.atan( (y)/Math.abs(x) ) );
		//third quadrant
		else if ( x < 0 && y < 0 )
			t = Math.toDegrees(Math.atan((y)/(x) ) + Math.PI);
		//forth qudrant
		else if ( x > 0 && y < 0 )
			t = - Math.toDegrees(Math.atan(Math.abs(y)/(x) ) );
		//border of first and second
		else if ( x == 0 && y > 0 )
			t=Math.PI/2;
		//border of third and forth
		else if (x == 0 && y < 0)
			t=(3/2)*Math.PI;
		//border of first and forth
		else if ( x > 0 && y ==0)
			t=0;
		else 
			t = Math.PI;
		return t;
	}
	
	public static double rValue( final double x, final double y) {
		return Math.sqrt(x*x*350*350 + y*y*300*300);
	}
}
