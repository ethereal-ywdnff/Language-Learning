package src.control.my_control;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame{
    public Test() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        MyControl control = new MyControl();
        panel.add(control);
        control.setPreferredSize(new Dimension(300, 250));
    }

    public static void main(String[] args) {
        Test frame = new Test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
