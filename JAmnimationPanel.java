import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 
import java.awt.geom.Line2D;
public class JAmnimationPanel extends JPanel { 
//100 SCALE
//100 = 1
	//Properties
		boolean blnfirst = true; 
		int intHeight; 
		int intWidth;
		ballobject ball = new ballobject (50,480,0,1000,-1000,0,9.8);
		Graphics2D graphics;
		
        
	//Methods/
	
	public void paintComponent (Graphics g)  {
		Graphics2D graphics = (Graphics2D) g; 
		this.graphics=graphics;
		g.clearRect(0,0,1000,1000);
		if( !blnfirst) { 
			ball.move(); 
		}
		blnfirst = false;
		ball.draw( graphics); 
		graphics.setColor (Color.GREEN) ; 
		g.fillRect(0,500,1000,100);
		
		
	}
	
	public void drawBall(){ 
		ball.draw(graphics);
	}
	public void setSize( int intH, int intW) { 
		intHeight = intH; 
		intWidth = intW;
	}
	
	//constructors 
	public JAmnimationPanel(){ 
		super();
	}
		
}
