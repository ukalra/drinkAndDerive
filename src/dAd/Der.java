package dAd;
import java.awt.Image;
import java.util.concurrent.ThreadLocalRandom;

public class Der {
	private vect pos;
	private int value;
	private String text;
	private double angle = 0;
	private double size;
	private int init;
	public boolean tell;
	public String[] problem = {"F(x) = 5",
			"F(x) = -2x",
			"F(x) = -2x^2 -5",
			"F(x) = 2x^4 +x^3 -x^2 +4",
			"F(x) = (x^3 + 2)/3",
			"F(x) = 1/3x^2",
			"F(x) = (x+1)/(x-1)",
			"F(x) = (5x^2 -3) * (x^2 + x + 4)",
			"F(x) = 5/ x^5",
			"F(x) = sqrt(x)",
			"F(x) = sqrt(x^2 -2x +3)",
			"F(x) = (x^2 +3x -2)^4",
			"F(x) = 10 ^ sqrt(x)",
			"F(x) = ln(2x^4 - x^3 + 3x^2 - 3x)",
			"F(x) = ln( (3^x +1) / (e^x -1) )" };


			public String[] correct = {"0",
			"-2",
			"-4x",
			"8x^3 + 3x^2 - 2x",
			"x^2",
			"-2/3x^3",
			"-2/(x-1)^2",
			"20x^3 + 15x^2 + 34x -3",
			"25/ x^6",
			"1/2sqrt(x)",
			"(x-1) / sqrt(x^2 -2x +3)",
			"4(x^2 +3x -2)^3 * (2x + 3)",
			"1/(2 * sqrt(x)) * 10^ sqrt(x) * ln(10)",
			"(8x^3 - 3x^2 + 6x - 3) / (2x^4 -x^3 +3x^2 -3x)",
			"(-2e^x) / (e^(2x) -1)"};

			public String[] wrong = {"5x",
			"-x",
			"-4x -5",
			"8x^3 + 3x - 2",
			"x^2 + 2/3",
			"1/6 x",
			"((x-1) + (x+1))/(x-1)^2",
			"10x * (2x + 1)",
			"1/x^4",
			"1/2 x^2",
			"1/ (x^2 -2x +3)",
			"4(2x + 3)^3 ",
			"ln(10) * 10^ sqrt(x)",
			"e ^ (2x^4 -x^3 +3x^2 -3x)",
			"(e^(2x) -1) / (-2e^x)"};

	public Der(int x, int y, int v, boolean leftRight) {
		setPos(new vect(x, y));
		value = v;
		init = y;
		tell = leftRight;
		if(leftRight){
			setText(correct[value]);			
			}else{
				setText(wrong[value]);	
			}
		if (Math.pow(value/2, 2) < 2) setSize(2);
		else setSize(Math.pow(value/2, 2));
	}
	public void update() {
		
		pos.setY(pos.getY() + 1);
	}
	public void upgrade() {
		value++;
		if(tell){
			setText(correct[value]);			
			}else{
				setText(wrong[value]);	
			}
		pos.setY(init);
	}
	public vect getPos() {
		return pos;
	}
	public void setPos(vect pos) {
		this.pos = pos;
	}
	
	public int getValue() {
		return value;
	}
	public double getAngle() {return angle;}
    public vect getCenterPos() { 
    	return new vect(
    			pos.getX() + value * size / 2.0, 
    			pos.getY() + value * size / 2.0, 0); 
    }
	public double getSize() {
		return size;
	}
	public void setSize(double d) {
		this.size = d;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
