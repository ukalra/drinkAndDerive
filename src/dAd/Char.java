package dAd;


import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public abstract class Char {
	protected vect vel = new vect(0, 0, 0);
	protected vect acc = new vect(0, 0, 0);
	protected vect pos = new vect(0, 0, 0);
    protected double scale = 1;	
    protected double scaleVel = 0;	
    protected double scaleAcc = 0;	
    protected double angAcc = 0;
    protected double angVel = 0;
    protected double angle  = 0;
    protected int width;
    protected int height;
    protected int health = 100;
    protected Image image;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static Thread animation;
    public double alpha = 1;
    
    public void update(int winX, int winY) {
    	final double eff = 0.95;//efficiency loss of speed
    	vel = (vel.times(eff)).plus(acc);//increases velocity by speed (with efficiency loss)
    	if(pos.getX() >= winX - width*scale ) 					vel.setX(-eff*Math.abs(vel.getX()));	
    	else if (pos.getX() <= 0) 								vel.setX(eff*Math.abs(vel.getX()));										
    	if(pos.getY() >= winY - height*scale ) 					vel.setY(-eff*Math.abs(vel.getY()));	
    	else if (pos.getY() <= 0) 								vel.setY(eff*Math.abs(vel.getY()));	
    	pos = pos.plus(vel);
    	angVel = angVel*eff*0.9 + angAcc;//updates velocity
    	angle += angVel;//updates angle
    	scaleVel = scaleVel*eff*0.8 + scaleAcc;
    	if(scale > 0.1) scale += scaleVel;
    	else scale += Math.abs(scaleVel);
    }

    public void die() {
    	health = 0;
    }
    //getters
    public int getX() { return (int)pos.getX(); }
    public int getY() { return (int)pos.getY(); }
    public vect getPos() {	return pos; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }    
    public double getAngle() { return angle; }
    public double getScale() { return scale; }
    public Image getImage() { return image; }
    public int getXcntr() {	return (int) (pos.getX() + scale * width / 2.0); }
    public int getYcntr() {	return (int) (pos.getY() + scale * height / 2.0); }
    
    public vect getCenterPos() { return new vect((pos.getX() + scale * width / 2.0), pos.getY() + scale * height / 2.0, 0); }
    public int getHealth() { return health; }
    //setters
    public void setAngle(float a) { angle = toRad(a); } 
    protected double toRad(double degrees) {
    	return (degrees * Math.PI / 180.0);
    }
}