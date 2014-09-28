import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*; 
import java.awt.geom.Line2D;
// - y means up 
// + x means forward
class ballobject {
	double dblX; 
	double dblY; 
	double dblAx; 
	double dblAy; 
	double dblH; 
	double dblVx; 
	double dblVy;
	double dblXi ; 
	double dblYi;
	double dblTimeCount = 0 ; 
	double dblTimeCurrent=0;
	public double getX(){ 
		return dblX; 
	}
	public double getY(){ 
		return dblY; 
	}
	public double getAx() { 
		return dblAx;
	}
	public double getAy() { 
		return dblAy;
	}
	public double getH() { 
		return dblH;
	} 
	
	public void move() {
		
		dblTimeCount+= dblTimeCurrent; 
		
		if(dblTimeCount==dblTimeCurrent){  
			dblY= dblYi+dblVy*dblTimeCurrent+.5*dblAy*dblTimeCurrent*dblTimeCurrent;
			dblX= dblXi+dblVx*dblTimeCurrent+.5*dblAx*dblTimeCurrent*dblTimeCurrent;
		}else { 
			dblVy =dblVy+dblAy*dblTimeCurrent; 
			dblVx =dblVx+dblAx*dblTimeCurrent; 
			dblY+= dblVy*dblTimeCurrent+.5*dblAy*dblTimeCurrent*dblTimeCurrent;
			dblX+= dblVx*dblTimeCurrent+.5*dblAx*dblTimeCurrent*dblTimeCurrent;
			
		}
		System.out.println("TIME : "+dblTimeCount);
		
// 				System.out.println("time: " + dblTimeCount);
// 		dblX=dblX+dblVx*dblTimeCount ;
// 		dblY=dblY+dblVy*dblTimeCount;
// 		dblX = dblVx*dblTimeCount;
// 		dblY = dblVy*dblTimeCount;
	}
	public void draw ( Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval((int)(dblX*10),(int)(dblY*10),20,20);
		System.out.println(dblX + " X CO");
		System.out.println(dblY + " Y CO");
	
	} 
	public void reset (double x, double y,double vx,double vy) {
		
	dblX =x; 
	dblY =y; 
	dblVx=vx;
	dblVy=vy;	
	dblTimeCount=0;
		
	}
	
	public ballobject ( double X, double y, double h,double vx, double vy, double ax, double ay ) { 
		dblX = X/10 ; 
		dblY = y/10; 
		dblH = h ; 
		dblAx = ax; 
		dblAy = ay ; 
		dblVx=vx;
		dblVy=vy;
		dblXi=dblX;
		dblYi=dblY;
		dblTimeCurrent= 0.01;
	}
}