package src.control.my_control.mouse;

import javax.swing.*;
import java.awt.*;

public class Mouse extends JPanel {
    public static boolean gao = false;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();
        int height = this.getHeight();

        g.setColor(new Color(0xFFFFF0));
        g.fillRect(0, 0, width, height);

        g.setColor(new Color(0x555555));
        g.drawRect(0, 0, width, height);
    }
}
