package enghacks;

/*
                 * To change this license header, choose License Headers in Project Properties.
                 * To change this template file, choose Tools | Templates
                 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Kevin
 */
public class ColorChooser extends JFrame {

    private JButton l;
    private static int r, b, g = 0;
    private Color color = new Color(r, b, g);
    private JPanel panel;
    

    public ColorChooser() {
        super("title");
        panel = new JPanel();
        panel.setBackground(color);

        l = new JButton("Choose a color");

        add(panel, BorderLayout.CENTER);
        add(l, BorderLayout.SOUTH);
        setSize(250, 450);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        tempToRBG(24.5);
        new ColorChooser();

    }

    public static void tempToRBG(double temp) {
        //temp: {-30, 30}
        if (temp >= 30) {
            r = 255;
            g = 0;
            b = 0;
        }//1
        else if (temp <= 30 && temp >= 15) {
            r = 255;
            g = (int) (255 * (Math.abs(Math.cos(Math.toRadians(((temp - 15) * 12) + 180)))));
            b = 0;
        }//2
        else if (temp <= 15 && temp >= 0) {
            r = 255;
            g = 255;
            b = (int) (255 * (Math.abs (Math.cos(Math.toRadians((temp * 12) + 180)))));
        }//3
        else if (temp <= 0 && temp >= -15) {
            r = (int) (255 * (Math.abs (Math.cos(Math.toRadians((temp+15) * 12)))));
            g = 255;
            b = 0;
        }//4
        else if (temp <= -15 && temp >= -30) {
            r = 0;
            g = (int) (255 * (Math.abs (Math.cos(Math.toRadians((temp+30) * 12)))));
            b = 255;
        } else if (temp <= -30) {
            r = 0;
            g = 0;
            b = 255;
        }
    }
}
