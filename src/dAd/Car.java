package dAd;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
public class Car extends Char{
	private int health = 10;
public Car(int x, int y, double scal){
	ImageIcon asset = new ImageIcon(getClass().getClassLoader().getResource( "car.png" ));
    image = asset.getImage(); 
    width = image.getWidth(null);
    height = image.getHeight(null);
    pos.setX(x);
    pos.setY(y);
    scale = scal;
    animation = new Thread();
    animation.start();
}
public void oof(int amount) {
	if(health > 0) health-= 1;
}
public void update(int winX, int winY) {
super.update(winX,  winY);
if(health < 1) {
	scale-=0.02; 
	angle++;
}
}
public int getHealth() {return health;}



public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    int amnt = 1;
    if(key == KeyEvent.VK_SHIFT)  amnt = 2;
    //movement
    if (key == KeyEvent.VK_LEFT  || key == KeyEvent.VK_A) 		acc.setX(-amnt);
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)		acc.setX(amnt);
   // if (key == KeyEvent.VK_UP    || key == KeyEvent.VK_W) 		acc.setY(-amnt);
   // if (key == KeyEvent.VK_DOWN  || key == KeyEvent.VK_S) 		acc.setY(amnt);
    //rotations
   // if (key == KeyEvent.VK_E) 		angAcc +=  Math.PI/180;//1 degree
    //if (key == KeyEvent.VK_Q) 		angAcc += -Math.PI/180;//1 degree
    //scale
    //if (key == KeyEvent.VK_O) 		scaleAcc =  0.01f;
    //if (key == KeyEvent.VK_P) 		scaleAcc = -0.01f;

}
public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();
	//movement
    if (key == KeyEvent.VK_LEFT  || key == KeyEvent.VK_A) 		acc.setX(0);
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)		acc.setX(0);
    if (key == KeyEvent.VK_UP    || key == KeyEvent.VK_W) 		acc.setY(0);
    if (key == KeyEvent.VK_DOWN  || key == KeyEvent.VK_S) 		acc.setY(0);
    //rotations
    //if (key == KeyEvent.VK_E) 		angAcc = 0;
   // if (key == KeyEvent.VK_Q) 		angAcc = 0;
    //scale
    //if (key == KeyEvent.VK_O) 		scaleAcc =  0;
    //if (key == KeyEvent.VK_P) 		scaleAcc =  0;
}
//mouse listeners
public void mouseMove(MouseEvent e) {
	//double mX = e.getX() - pos.getX();
	//double mY = e.getY() - pos.getY() - scale*0.5*height;
	//angular movement;
	//angle = Math.atan2(mY, mX);//(mY / mX);
}

}