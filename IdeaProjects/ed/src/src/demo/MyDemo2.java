package src.demo;

import javax.swing.*;

public class MyDemo2 {
    public static class MyFrame extends JFrame {
        public MyFrame() {
            this.setTitle("Swing Example");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            this.setContentPane(panel);

            JButton button = new JButton("test");
            panel.add(button);

            JLabel label = new JLabel("hello");
            panel.add(label);
            panel.add(new JLabel("world"));

            this.setSize(400, 300);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new MyFrame();
    }
}
