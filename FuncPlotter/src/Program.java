import java.awt.Color;

import graphics.Canvas;

public class Program {
	// Canvas GUI instance providing the drawing area on which to plot the functions
	private static Canvas canvas;

	public static void main(String[] args) {
        
        // Create the canvas instance, set its range to x:[-360, 360] and y:[-240, 240] then 
        // open it on the screen. Use canvas.plot(pX, pY) to plot a point at the (pX, pY) coords
        canvas = new Canvas();
        canvas.setRange(-360, -240, 360, 240);
        canvas.open();

        // Draw a short red diagonal on the canvas
        canvas.pause();
        canvas.setColor(Color.red);
        GetY sin = new GetY () {
        	public int calcY(int i) {
        	return (int) (200 * Math.sin(Math.PI * i/360));
        	}
        	public Color getColor() {
        		return Color.RED;
        	}
        };
        GetY quadratic = new GetY () {
        	public int calcY(int x) {
        		return  (int) ((x-200)  * (x+200) /250 ); 
        	}
        	public Color getColor() {
        		return Color.green;
        	}
        };
        GetY log = new GetY () {
        	public int calcY(int x) {
        		return (int) (20 * Math.log(x)); 
        	}
        	public Color getColor() {
        		return Color.CYAN;
        	}
        };
        GetY cubic = new GetY () {
        	public int calcY(int x) {
        		return (int) (Math.pow(x, 3)/200000); 
        	}
        	public Color getColor() {
        		return Color.MAGENTA;
        	}
        };

       
        
        GetY[] functions = {quadratic, sin, log, cubic};
        
        
        plotFunction(functions);
        plotFunction();
        canvas.pause();
        canvas.close();
    }	
	/** Plots a given function
	 * 
	 * @param function is the function to plot
	 */
	public static void plotFunction (GetY... functions) {
		
		for(int x = 0; x < functions.length; x++) {
			canvas.setColor(functions[x].getColor());
        for (int i = -360; i < 360; i++) {
            canvas.plot(i, functions[x].calcY(i));
        }
		}
	}
}
