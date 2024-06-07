package src.control.my_control.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * mouseEntered()
 * mouseExited()
 */
public class Test02 extends JFrame{
    public Test02() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        Mouse mouse = new Mouse();
        panel.add(mouse);
        mouse.setPreferredSize(new Dimension(120, 120));

        mouse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouse entered...");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouse exited...");
            }
        });
    }

    public static void main(String[] args) {
        Test02 frame = new Test02();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
