package src.control.my_control.picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyPicture extends JPanel {
    BufferedImage image;
    public MyPicture() {
        try {
            File file = new File("data/Klaus.jpg");
            image = ImageIO.read(file);

        } catch (Exception e) {
            System.out.println("can't read the image");;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        int fitWidth = width;
        int fitHeight = width * imgHeight / imgWidth;
        if (fitHeight > height) {
            fitHeight = height;
            fitWidth = height * imgWidth / imgHeight;
        }
        int fitX = (width - fitWidth) / 2;
        int fitY = (height - fitHeight) / 2;
        g.drawImage(image, fitX, fitY, fitWidth, fitHeight, null);
    }
}
