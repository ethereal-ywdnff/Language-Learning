package src.control.my_control.sine_curve;

import javax.swing.*;
import java.awt.*;

public class SineTest extends JFrame {
    public SineTest() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        Sine control = new Sine();
        panel.add(control);
        control.setPreferredSize(new Dimension(300, 250));
    }
    public static void main(String[] args) {
        SineTest frame = new SineTest();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
