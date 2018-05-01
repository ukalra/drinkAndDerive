package dAd;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Starter extends JFrame {

    public Starter() {
    	add(new Bg());
        setTitle("Drink And Derive");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        //setSize(1500, 750);
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