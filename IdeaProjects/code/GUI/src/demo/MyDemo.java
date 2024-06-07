package demo;

import javax.swing.*;

public class MyDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing Example");
        //frame.setTitle("123");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        JButton button = new JButton("test");
        panel.add(button);

        JLabel label = new JLabel("hello");
        panel.add(label);
        panel.add(new JLabel("world"));

        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
