package src.control.my_control.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * mousePressed()
 */
public class Test extends JFrame {
    public Test() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        Mouse mouse = new Mouse();
        panel.add(mouse);
        mouse.setPreferredSize(new Dimension(120, 120));

        mouse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("location: " + e.getPoint());

                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("left button");
                }
                if (e.getButton() == MouseEvent.BUTTON2) {
                    System.out.println("middle button");
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("right button");
                }
            }

        });
//        mouse.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("mouse pressed...");
//                System.out.println("location: " + e.getPoint());
//
//                if (e.getButton() == MouseEvent.BUTTON1) {
//                    System.out.println("left button");
//                }
//                if (e.getButton() == MouseEvent.BUTTON2) {
//                    System.out.println("middle button");
//                }
//                if (e.getButton() == MouseEvent.BUTTON3) {
//                    System.out.println("right button");
//                }
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent e) {
//
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//
//            }
//        });
    }

    public static void main(String[] args) {
        Test frame = new Test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
