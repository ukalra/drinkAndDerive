package dAd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.JPanel;
import javax.swing.Timer;
public class Bg extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Timer timer;
	 public Dimension screenSize;
	    private final int msDELAY = 10;
	    private Car vehicle;
	    private int problemControl = 0;
	    public Der correct;
	    public Der incorrect;
	    public int score = 0;
	    public String finish = "";;
	    
public Bg(){
	addKeyListener(new TAdapter());
	addMouseMotionListener(new MAdapter());
	addMouseListener(new MButtonAdapter());
	screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    setFocusable(true);
    setBackground(Color.black);
    setDoubleBuffered(true);
    double rando = Math.random();
    int posC;
    int posI;
    if(rando < 0.5){
    	posC = 2*(int)screenSize.getWidth()/6;
    	posI = 4*(int)screenSize.getWidth()/6;
    }else{
    	posC = 4*(int)screenSize.getWidth()/6;
    	posI = 2*(int)screenSize.getWidth()/6;
    	
    }
     correct = new Der(posC, 2*(int)screenSize.getHeight()/6, problemControl, true);
     incorrect = new Der(posI, 2*(int)screenSize.getHeight()/6, problemControl, false);
    vehicle = new Car((int)screenSize.getWidth()/2, 4*(int)screenSize.getHeight()/6, 0.2);
    timer = new Timer(msDELAY, this);
    timer.start();
  
}

  
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
    Toolkit.getDefaultToolkit().sync();
}


private void doDrawing(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.rotate(vehicle.getAngle(), vehicle.getXcntr(), vehicle.getYcntr());
    g2d.setColor(new Color(255, 255, 255));
    g2d.setFont(new Font("Verdana", Font.BOLD, 80));
  int oof =(int)g2d.getFontMetrics().getStringBounds("Drink And Derive", g2d).getWidth() / 2;
  g2d.drawString("Drink And Derive", (int)screenSize.getWidth()/2 - oof, (int)screenSize.getHeight()/6);
  g2d.setFont(new Font("Verdana", Font.BOLD, 30));
  g2d.drawString(correct.getText(), (int)correct.getPos().getX(), (int)correct.getPos().getY());
  g2d.drawString(incorrect.getText(), (int)incorrect.getPos().getX(), (int)incorrect.getPos().getY());
  int oof2 =(int)g2d.getFontMetrics().getStringBounds(correct.problem[correct.getValue()], g2d).getWidth() / 2;
  

    g2d.drawString(correct.problem[correct.getValue()], (int)screenSize.getWidth()/2 - oof2, 2*(int)screenSize.getHeight()/6);
    g2d.setFont(new Font("Verdana", Font.BOLD, 60));
    
    g2d.drawString("Score: "+ score+finish, 0*(int)screenSize.getWidth()/6, (int)screenSize.getHeight()/6);
correct.update();
incorrect.update();
    g2d.drawImage(vehicle.getImage(), vehicle.getX(), vehicle.getY(), (int)(vehicle.getScale() * vehicle.getWidth()), (int)(vehicle.getScale() * vehicle.getHeight()), this);
    g2d.rotate(-vehicle.getAngle(), vehicle.getXcntr(), vehicle.getYcntr());
    g2d.dispose();
    
}


@Override
public void actionPerformed(ActionEvent e) {  
	vehicle.update(getWidth(), getHeight());
	  double dist = correct.getSize() + vehicle.getWidth()*vehicle.getScale()/2;
	  double dist2 = incorrect.getSize() + vehicle.getWidth()*vehicle.getScale()/2;
       if(vehicle.getCenterPos().distanceSqr(correct.getCenterPos()) < Math.pow(dist, 2)) {
  		
  		if(correct.getValue() < correct.problem.length){
  			score++;
  			double rando = Math.random();
  		    int posC;
  		    int posI;
  		    if(rando < 0.5){
  		    	posC = 2*(int)screenSize.getWidth()/6;
  		    	posI = 4*(int)screenSize.getWidth()/6;
  		    }else{
  		    	posC = 4*(int)screenSize.getWidth()/6;
  		    	posI = 2*(int)screenSize.getWidth()/6;
  		    }
  		    correct.getPos().setX(posC);
  		  incorrect.getPos().setX(posI);
  			correct.upgrade();
  		incorrect.upgrade();}else{
  			
  			finish = "You Win!";
  		}
  	}
       else if(vehicle.getCenterPos().distanceSqr(incorrect.getCenterPos()) < Math.pow(dist2, 2)){
  	
  		if((correct.getValue() < correct.problem.length)&&(score > -1)){
  			score--;
  			double rando = Math.random();
  		    int posC;
  		    int posI;
  		    if(rando < 0.5){
  		    	posC = 2*(int)screenSize.getWidth()/6;
  		    	posI = 4*(int)screenSize.getWidth()/6;
  		    }else{
  		    	posC = 4*(int)screenSize.getWidth()/6;
  		    	posI = 2*(int)screenSize.getWidth()/6;
  		    }
  		    correct.getPos().setX(posC);
  		  incorrect.getPos().setX(posI);
  			correct.upgrade();
  	  		incorrect.upgrade();}else{
  	  		
  	  			finish = " Game Over...";
  	  		}
  	}
       if(correct.getPos().getY() > (int)screenSize.getHeight()){
     		
     		if((correct.getValue() < correct.problem.length)&&(score > -1)){
     			score--;
     			double rando = Math.random();
      		    int posC;
      		    int posI;
      		    if(rando < 0.5){
      		    	posC = 2*(int)screenSize.getWidth()/6;
      		    	posI = 4*(int)screenSize.getWidth()/6;
      		    }else{
      		    	posC = 4*(int)screenSize.getWidth()/6;
      		    	posI = 2*(int)screenSize.getWidth()/6;
      		    }
      		    correct.getPos().setX(posC);
      		  incorrect.getPos().setX(posI);
     			correct.upgrade();
      	  		incorrect.upgrade();}else{
      	  		
      	  			finish = " Game Over...";
      	  		}
     	}
	
	repaint(0, 0, getWidth(), getHeight());     
}


private class TAdapter extends KeyAdapter {
    @Override
    public void keyReleased(KeyEvent e) { 
        vehicle.keyReleased(e); 

    }
    @Override
    public void keyPressed(KeyEvent e) { 
    	vehicle.keyPressed(e); 

    }
}
private class MAdapter extends MouseAdapter {
	@Override
    public void mouseMoved(MouseEvent e) {
    	vehicle.mouseMove(e);

    }
}
private class MButtonAdapter extends MouseAdapter {
	@Override
    public void mousePressed(MouseEvent e) {
		   
	}
}
}

