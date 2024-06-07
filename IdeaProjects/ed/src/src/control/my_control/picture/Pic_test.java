package src.control.my_control.picture;

import javax.swing.*;
import java.awt.*;

public class Pic_test extends JFrame {
    public Pic_test() {

        MyPicture control = new MyPicture();
        this.setContentPane(control);
    }

    public static void main(String[] args) {
        Pic_test frame = new Pic_test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
