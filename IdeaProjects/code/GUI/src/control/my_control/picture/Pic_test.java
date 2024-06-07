package control.my_control.picture;

import javax.swing.*;
import java.awt.*;

public class Pic_test extends JFrame {
    public Pic_test() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        MyPicture control = new MyPicture();
        panel.add(control);
        control.setPreferredSize(new Dimension(300, 250));
    }

    public static void main(String[] args) {
        Pic_test frame = new Pic_test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
