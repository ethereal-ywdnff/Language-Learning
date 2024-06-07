package src;

import javax.swing.*;

public class Label {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("label");
        frame.setSize(300,200);
        frame.setLocation(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JLabel label = new JLabel();
        frame.add(label);
        label.setText("bro?");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
    }
}
