package src;

import javax.swing.*;
import java.awt.*;

public class Panel {
    public static void main(String[] args) {
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0,0,250,250);
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250,0,250,250);

        JLabel label = new JLabel();
        label.setText("oooo");

        JFrame frame = new JFrame();
        frame.setTitle("label");
        frame.setSize(600,600);
        frame.setLocation(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(redPanel);
        frame.add(bluePanel);
        redPanel.add(label);
    }
}
