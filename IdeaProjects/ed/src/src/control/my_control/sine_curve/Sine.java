package src.control.my_control.sine_curve;

import javax.swing.*;
import java.awt.*;

public class Sine extends JPanel {
    public int grain = 3;
    public int radius = 50;
    public int period = 100;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();//控件宽度
        int height = this.getHeight();//控件高度

        int center = height/2;
        g.setColor(Color.BLUE);
        g.drawLine(0, center, width, center);

        int x1 = 0;
        int y1 = 0;
        for (int i = 0; i < width; i += grain) {
            int x2 = i;
            double angle = 2 * Math.PI * x2 / period;

            int y2 = (int) (radius * Math.sin(angle));

            g.drawLine(x1, center + y1, x2, center + y2);

            x1 = x2;
            y1 = y2;
        }
    }
}
