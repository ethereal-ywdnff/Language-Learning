package src.control.my_control.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Test03 extends JFrame{
    public Test03() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        Mouse mouse = new Mouse();
        panel.add(mouse);
        mouse.setPreferredSize(new Dimension(120, 120));

        
    }

    public static void main(String[] args) {
        Test03 frame = new Test03();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
