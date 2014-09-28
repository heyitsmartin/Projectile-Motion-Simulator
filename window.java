import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 

public class window implements ActionListener, MouseMotionListener,ChangeListener {
	JFrame theframe; 
	JAmnimationPanel thepanel;
	JPanel thepanel1; 
	Timer animtimer;
	int intWidth = 1024; 
	int intHeight = 768; 
	boolean go = false; 
	boolean blnStats= false;
	JButton start = new JButton ();
	JButton stop = new JButton ();
	JButton reset = new JButton ();
	JButton stats = new JButton ();
	JSlider startv = new JSlider(); 
	JSlider angle = new JSlider(); 
	JLabel startvelocity = new JLabel () ; 
	JLabel startangle = new JLabel();
	JLabel vXdisplay = new JLabel();
	JLabel vYdisplay = new JLabel();
	statswindow window2 = new statswindow();
	double dblAngle = 0 ; 
	double dblVelocity = 0 ;
	 
	//Methods
	public int width()  {
		return intWidth;
	}
	public void updateBallPrefPane() { 
		thepanel.ball.dblTimeCurrent = window2.window3.dblT;
		System.out.println(window2.window3.dblT+""); 
		thepanel.ball.dblAx = window2.window3.dblXA; 
		thepanel.ball.dblAy = window2.window3.dblYA; 	
		
	} 
	public int height() { 
		return intHeight;
	}
	public void stateChanged(ChangeEvent e ) {
		JSlider source = (JSlider) e.getSource();
		thepanel.ball.dblTimeCount = 0 ; 
		if( source == angle) {
			dblAngle = source.getValue();
			startangle.setText(Double.toString(dblAngle)+"Degrees");
		}
		if( source == startv) { 
			dblVelocity = source.getValue();
			startvelocity.setText(Double.toString(dblVelocity)+"M/S");
		}
		thepanel.ball.dblVx = vX(dblVelocity,dblAngle);
		thepanel.ball.dblVy = vY(dblVelocity,dblAngle); 
		vXdisplay.setText(thepanel.ball.dblVx+"M/S in X Axis");
		vYdisplay.setText(thepanel.ball.dblVy*(-1)+"M/S in Y Axis");
		System.out.println(vX(dblVelocity,dblAngle)*100);
		go=false;
		
	}
	public void mouseMoved(MouseEvent e){
		
	}
	public void mouseDragged(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){
	
	}
	public void mouseEntered(MouseEvent e) { 
		
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == animtimer&& go ) {
			updateBallPrefPane();
			this.window2.update(thepanel.ball.dblVy,thepanel.ball.dblVx,thepanel.ball.dblX,thepanel.ball.dblY,thepanel.ball.dblAx,thepanel.ball.dblAy,thepanel.ball.dblTimeCount);
			
			if(thepanel.ball.getY()>= thepanel.ball.dblYi+1){
				
				thepanel.ball.dblY = thepanel.ball.dblYi;
								
				go = false;
			}
			thepanel.repaint();
		}
		if (e.getSource() == start ) { 
			go=true;
		}
		if (e.getSource() == stop ) { 
			go=false;
		}
		if (e.getSource() == reset ) { 
			thepanel.ball.reset(50,480, vX(dblVelocity,dblAngle), vY(dblVelocity,dblAngle));
			thepanel.repaint();
		}
		if(e.getSource()==stats) { 
			
			blnStats= !blnStats; 
			window2.show(blnStats);
		}
	}
	public window () { 
		
		
		
		theframe = new JFrame("Projectile Motion "); 
		theframe.setSize(intWidth,intHeight);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setResizable(false);
		theframe.setVisible(true);
		//THEPANEL
		thepanel = new JAmnimationPanel(); 
		thepanel.setLayout(null);
		thepanel.addMouseMotionListener(this);
		thepanel.setBounds(0,0,intWidth,intHeight-175);
		
		//THEPANEL1
		thepanel1 = new JPanel(); 
		thepanel1.setLayout(null);
		thepanel1.addMouseMotionListener(this);
		thepanel1.setSize(intWidth,intHeight);
		 
		
		animtimer = new Timer ( 17,this);
		animtimer.start();
		
		//ADDS PANEL TO FRAME
		theframe.add(thepanel); 
		this.theframe.add(this.thepanel1);
		
		//START BUTTON
		this.start = new JButton ("START");
		this.start.setBounds (1024-160,670,100,50);
		this.thepanel1.add(this.start);
		this.start.addActionListener(this);
		//STOP BUTTON
		this.stop = new JButton ("STOP");
		this.stop.setBounds (1024-290,670,100,50);
		this.thepanel1.add(this.stop);
		this.stop.addActionListener(this);
		//RESET BUTTON
		this.reset = new JButton ("RESET");
		this.reset.setBounds (1024-290,610,100,50);
		this.thepanel1.add(this.reset);
		this.reset.addActionListener(this);
		//STATS BUTTON
		this.stats = new JButton ("STATS");
		this.stats.setBounds (1024-160,610,100,50);
		this.thepanel1.add(this.stats);
		this.stats.addActionListener(this);
		//STARTING VELOCITY
		this.startv = new JSlider (0, 0,30,10); 
		this.startv.setBounds(50,670,300,50);
		this.startv.addChangeListener(this);
		this.thepanel1.add(this.startv);
		//STARTING ANGLE
		this.angle = new JSlider (0, 0,90,45); 
		this.angle.setBounds(50,610,300,50);
		this.angle.addChangeListener(this);
		this.thepanel1.add(this.angle);
		//STARTING ANGLE LABEL
		this.startvelocity = new JLabel (Double.toString(dblAngle),JLabel.LEFT);
		this.startvelocity.setVisible(true); 
		this.startvelocity.setBounds(400,670,300,50);
		this.thepanel1.add(this.startvelocity);
		//STARTING VELOCITY LABEL
		this.startangle = new JLabel (Double.toString(dblVelocity),JLabel.LEFT);
		this.startangle.setVisible(true); 
		this.startangle.setBounds(400,610,300,50);
		this.thepanel1.add(this.startangle);
		//STARTING VELOCITY X AXIS LABEL
		this.vXdisplay = new JLabel ("HI",JLabel.LEFT);
		this.vXdisplay.setVisible(true); 
		this.vXdisplay.setBounds(480,610,300,50);
		this.thepanel1.add(this.vXdisplay);
		//STARTING VELOCITY Y AXIS LABEL
		this.vYdisplay = new JLabel ("HI",JLabel.LEFT);
		this.vYdisplay.setVisible(true); 
		this.vYdisplay.setBounds(480,670,300,50);
		this.thepanel1.add(this.vYdisplay);
		//SETS INITIAL BALL STUFF
		thepanel.ball.reset(50,480, vX(dblVelocity,dblAngle), vY(dblVelocity,dblAngle));
		thepanel.repaint();
		vXdisplay.setText(thepanel.ball.dblVx+"M/S in X Axis");
		vYdisplay.setText(thepanel.ball.dblVy*(-1)+"M/S in Y Axis");
		
	}
	
	public double vY(double v, double a) { 
		System.out.println("A VALUE "+ a);
		System.out.println("SIN "+Math.sin(Math.toRadians(a)));
		return -(v*(Math.sin(Math.toRadians(a))));
		
	}
	public double vX(double v, double a) { 
		System.out.println("A VALUE "+ a);
		
		if((Math.cos(Math.toRadians(a)))>0.0000000001){
			System.out.println("COS "+Math.cos(Math.toRadians(a)));
			return (v*(Math.cos(Math.toRadians(a))));	
			
		} else {
			System.out.println("0");
			return 0; 
			
		}
	}
	
	
	
}