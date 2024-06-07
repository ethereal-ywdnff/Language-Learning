package control.my_control.picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyPicture extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        try {
            File file = new File("data/KC.jpg");
            BufferedImage image = ImageIO.read(file);
            g.drawImage(image, 0, 0, width, height, null);
        } catch (Exception e) {
            System.out.println("can't read the image");;
        }
    }
}
