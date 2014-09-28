import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 
import java.awt.Frame.*;
// - y means up 
// + x means forward
class statswindow implements ActionListener{
	//Properties
	JPanel thepanel; 
	JFrame theframe; 
	prefPane window3;
	JLabel[] labels = new JLabel[7];
	Double [] values  = new Double [7]; 
	JButton Vx; 
	JButton Vy; 
	JButton Dx; 
	JButton Dy; 
	JButton T; 
	JButton Ax;
	JButton Ay;  
	JMenuBar menubar; 
	JMenu filemenu;
	JMenuItem fileitems; 
	JOptionPane thepane = new JOptionPane();
	
	//Methods 
	public void actionPerformed(ActionEvent e) { 
		System.out.println("Selected: " + e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("About")) { 	
			thepane.showMessageDialog(theframe, "ST AUGUSTINE CHS \n"
												+"ICS4U 2012-2013\n"
												+"Mr. Cadawas \n" 
												+"Martin Li" , " Credits",
												JOptionPane.INFORMATION_MESSAGE);
		}else if(e.getActionCommand().equalsIgnoreCase("Preferences")) { 
			window3.show();	
		}else if(e.getActionCommand().equalsIgnoreCase("Secret to life")) { 
			thepane.showMessageDialog(theframe,"", "", JOptionPane.INFORMATION_MESSAGE); 	
			thepane.showMessageDialog(theframe,"It's an Existentialism joke.", "Sup", JOptionPane.INFORMATION_MESSAGE); 	
		}
	}
	public void show(Boolean blnShow) { 
		theframe.setVisible(blnShow) ;
	}
	public void update ( double vy, double vx, double dx, double dy, double ax, double ay, double t) {
		values[0] = vx;
		values[1] = vy;
		values[2] = dx-50+39+6;
		values[3] = dy-480+400+30;
		values[4] = ax;
		values[5] = -ay;
		values[6] = t;
		if(values[3]>0){
			values[3] = 0.0;
		}
		this.Vx.setText(Double.toString(values[0]));
		this.Vy.setText(Double.toString(values[1]));
		this.Dx.setText(Double.toString(values[2]));
		this.Dy.setText(Double.toString(values[3]));
		this.Ax.setText(Double.toString(values[4]));
		this.Ay.setText(Double.toString(values[5]));
		this.T.setText(Double.toString(values[6]));
		
	}
	//Constructor 
	
	public statswindow() {
		//Preference pane 
		 window3 = new prefPane(false); 
		//THEFRAME
		theframe = new JFrame("Statistics"); 
		theframe.setSize(300,500);
		theframe.setResizable(false);
		
		//THEPANEL
		thepanel = new JPanel(); 
		thepanel.setLayout(null);
		
		this.theframe.setContentPane(this.thepanel);
		
		//MENUS
		this.menubar = new JMenuBar();
		this.menubar.setBounds(0,0,350,20);
		this.menubar.setVisible(true);
		this.thepanel.add(this.menubar);
		
		this.filemenu = new JMenu ("File"); 
        this.menubar.add(this.filemenu);
		
        this.fileitems = new JMenuItem("About");
        this.filemenu.add(fileitems);
        this.fileitems.addActionListener(this);
        this.fileitems = new JMenuItem("Preferences");
        this.filemenu.add(fileitems);
        this.fileitems.addActionListener(this);
        this.fileitems = new JMenuItem("Secret to life");
        this.filemenu.add(fileitems);
        this.fileitems.addActionListener(this);
        //BUTTONS
		this.Vx = new JButton ("Vx"); 
		this.Vx.setBounds(210,40,70,40);
		this.Vx.setEnabled(false);
		this.thepanel.add(this.Vx); 
		
		this.Vy = new JButton ("Vy"); 
		this.Vy.setBounds(210,100,70,40);
		this.Vy.setEnabled(false);
		this.thepanel.add(this.Vy); 
		
		this.Dx = new JButton ("Dx"); 
		this.Dx.setBounds(210,160,70,40);
		this.Dx.setEnabled(false);
		this.thepanel.add(this.Dx); 
		
		this.Dy = new JButton ("Dy"); 
		this.Dy.setBounds(210,220,70,40);
		this.Dy.setEnabled(false);
		this.thepanel.add(this.Dy);  
		
		this.Ax = new JButton ("Ax"); 
		this.Ax.setBounds(210,280,70,40);
		this.Ax.setEnabled(false);
		this.thepanel.add(this.Ax); 
		
		this.Ay = new JButton ("Ay"); 
		this.Ay.setBounds(210,340,70,40);
		this.Ay.setEnabled(false);
		this.thepanel.add(this.Ay);
		
		this.T = new JButton ("T"); 
		this.T.setBounds(210,400,70,40);
		this.T.setEnabled(false);
		this.thepanel.add(this.T);
		
		//LABELS
		for(int i = 0 ; i<7;i++){
			labels[i] = new JLabel();
			labels[i].setBounds(20,40+60*i,150,40);
			labels[i].setVisible(true);
			thepanel.add(labels[i]);
		}
		
		labels[0].setText("X-axis Velocity"); 
		labels[1].setText("Y-axis Velocity"); 
		labels[2].setText("X-axis Displacement"); 
		labels[3].setText("Y-axis Displacement"); 
		labels[4].setText("X-axis Acceleration"); 
		labels[5].setText("Y-axis Acceleration"); 
		labels[6].setText("Time Elapsed"); 
		
		//CHANGE THIS AFTER YOU ARE DONE MARTIN! DONT FORGET
		theframe.setVisible(true); 
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
	}
	
	public static void main (String[] args) {
		statswindow window2 = new statswindow();
		
		
	}		
	
}