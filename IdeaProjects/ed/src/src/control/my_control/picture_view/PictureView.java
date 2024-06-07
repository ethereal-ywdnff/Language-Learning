package src.control.my_control.picture_view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 封装，只需要调用就能加载图片，所有人都能用
 */
public class PictureView extends JPanel {
    private Image image;
    private Color bgColor;

    public void setBackgroundColor(Color color) {
        this.bgColor = color;
        this.repaint();
    }

    public PictureView() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        if (bgColor != null) {
            g.setColor(bgColor);
            g.fillRect(0, 0, width, height);
        }

        if(true) {
            g.setColor(new Color(0x404040));
            g.drawRect(0, 0, width, height);
        }
        if (image != null) {
            int imgWidth = image.getWidth(null);
            int imgHeight = image.getHeight(null);

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

    public void setImage(Image image) {
        this.image = image;
        this.repaint();
    }
}
