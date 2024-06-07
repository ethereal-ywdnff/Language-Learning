package src.control.my_control.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * mousePressed()
 * mouseReleased()
 * mouseClicked()
 */
public class Test01 extends JFrame{
    public Test01() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        Mouse mouse = new Mouse();
        panel.add(mouse);
        mouse.setPreferredSize(new Dimension(120, 120));

        mouse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("moused clicked...");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse pressed..");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse released...");
            }
        });

        JButton button = new JButton("test");
        panel.add(button);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("moused clicked...");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse pressed..");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse released...");
            }
        });
    }

    public static void main(String[] args) {
        Test01 frame = new Test01();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
