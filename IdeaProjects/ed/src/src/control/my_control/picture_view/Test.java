package src.control.my_control.picture_view;

import src.control.my_control.picture.MyPicture;
import src.control.my_control.picture.Pic_test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Test extends JFrame{
    public Test() {
        PictureView c = new PictureView();

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.add(c);
        c.setPreferredSize(new Dimension(250, 250));
        c.setBackgroundColor(Color.lightGray);

        try {
            Image image = ImageIO.read(new File("data/KC.jpg"));
            c.setImage(image);
        } catch (Exception e) {
            System.out.println("cannot load the picture");
        }
    }

    public static void main(String[] args) {
        Test frame = new Test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
