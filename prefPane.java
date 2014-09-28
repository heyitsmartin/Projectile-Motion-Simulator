import java.awt.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import java.awt.event.*;
import javax.swing.event.*; 
import java.awt.Frame.*;
import javax.swing.text.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.text.*;
class prefPane implements ActionListener { 

	//Properties
	JPanel thepanel; 
	JFrame theframe; 
	JOptionPane thepane = new JOptionPane();
	JLabel[] labels = new JLabel[3];
	JTextField YA; 
	JTextField XA;
	JTextField T;  
	JButton Ok ; 
	JButton Cancel; 
	double dblYA = 9.8;
	double dblXA = 0 ;
	double dblT = 0.01 ;
	  
	//Methods 
	public void actionPerformed(ActionEvent e ) { 
		if(e.getSource()== Ok ) {
			update();
		}else if( e.getSource() == Cancel) { 
			theframe.setVisible(false);
		}
	}
	public void show () { 
		theframe.setVisible(true);
	}
	public double getXA () { 
		return dblXA;
	}
	public double getYA () { 
		return dblYA;
	}
	public double getT () { 
		return dblT;
	}
	public void update(){
		try{
			dblYA = -Double.parseDouble(YA.getText());
			dblXA = Double.parseDouble(XA.getText());
			dblT = Double.parseDouble(T.getText())/100;
			
			theframe.setVisible(false);
		}catch(Exception e ) {
			thepane.showMessageDialog(theframe, " INVALID INPUT","Input Warning",	
			thepane.ERROR_MESSAGE); 
		}
	}
	//Contructor 
	public prefPane(Boolean blnShow) { 
		
		//THEFRAME
		theframe = new JFrame("Preferences"); 
		theframe.setSize(300,250);
		theframe.setResizable(false);
		
		//THEPANEL
		thepanel = new JPanel(); 
		thepanel.setLayout(null);
		this.theframe.setContentPane(this.thepanel);
		//THEPANE
		this.theframe.add(thepane);
		//Labels
		for(int i = 0 ; i<3;i++){
			labels[i] = new JLabel();
			labels[i].setBounds(10,10+60*i,150,40);
			labels[i].setVisible(true);
			thepanel.add(labels[i]);
		}
		labels[0].setText("Yaxis accel. (m/s^2)"); 
		labels[1].setText("Xaxis accel. (m/s^2)"); 
		labels[2].setText("Speed Multiplier");
		//TEXTFIELDS AND WHATNOT
		YA = new JTextField(); 
		YA.setBounds(200,20,50,20);
		thepanel.add(YA);
		
		XA = new JTextField(); 
		XA.setBounds(200,80,50,20);
		thepanel.add(XA);
		
		T = new JTextField(); 
		T.setBounds(200,140,50,20);
		thepanel.add(T);
		//Buttons
		Ok = new JButton();
		Ok.setText("OK");
		Ok.setBounds(40,170,80,40);
		thepanel.add(Ok);
		Ok.addActionListener(this);
		
		
		Cancel = new JButton();
		Cancel.setText("Cancel");
		Cancel.setBounds(170,170,80,40);
		thepanel.add(Cancel);
		Cancel.addActionListener(this);
		
		//Sets frame visible 
		theframe.setVisible(blnShow);
	}
	public static void main (String[] args) {
		prefPane window3 = new prefPane(true);
		
		
	}		
}
