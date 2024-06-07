package control.my_control;

import javax.swing.*;
import java.awt.*;

public class MyControl extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = this.getWidth();//控件宽度
        int height = this.getHeight();//控件高度

        g.setColor(new Color(0x6BFF54, true));//true: 隐身
        g.fillRect(0, 0, width, height);

        g.setColor(new Color(255, 0, 255, 250));//a: 隐身 0-255 0是不显示
        g.fillOval(50, 50, 60, 30);

        g.setColor(new Color(0, 0, 0, 250));
        g.fillArc(100, 100, 60, 30, 0, 120);//0度开始，逆时针120度

        g.setColor(new Color(0, 0, 0, 250));
        g.drawOval(200, 200, 60, 30);

        g.drawLine(0, 0, 100, 200);
    }

}
