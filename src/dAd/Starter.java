package dAd;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Starter extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	public Starter() {
    	add(new Bg());
        setTitle("Drink And Derive");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Starter program = new Starter();
            program.setVisible(true);
        });
    }
}