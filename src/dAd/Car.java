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

    if (key == KeyEvent.VK_LEFT  || key == KeyEvent.VK_A) 		acc.setX(-amnt);
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)		acc.setX(amnt);


}
public void keyReleased(KeyEvent e) {
	int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT  || key == KeyEvent.VK_A) 		acc.setX(0);
    if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)		acc.setX(0);
    if (key == KeyEvent.VK_UP    || key == KeyEvent.VK_W) 		acc.setY(0);
    if (key == KeyEvent.VK_DOWN  || key == KeyEvent.VK_S) 		acc.setY(0);

}

public void mouseMove(MouseEvent e) {

}

}