package src.layout.self_layout;

import javax.swing.*;
import java.awt.*;

/**
 * with SimpleLayout
 */
public class Self extends JFrame{
    ColorLabel label1 = new ColorLabel("aaa", Color.yellow);
    ColorLabel label2 = new ColorLabel("bbb", Color.green);
    ColorLabel label3 = new ColorLabel("ccc", Color.lightGray);
    ColorLabel label4 = new ColorLabel("ddd", Color.CYAN);
    ColorLabel label5 = new ColorLabel("eee", Color.red);

    public Self() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.setLayout(new MyCustomLayout());

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
    }
    public static void main(String[] args) {
        Self frame = new Self();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    private class MyCustomLayout extends LayoutAdapter {
        @Override
        public void layoutContainer(Container parent) {//调动窗口大小时，改动label
            int width = parent.getWidth();
            int height = parent.getHeight();

//            label1.setLocation(0, 0);
//            label1.setSize(label1.getPreferredSize());
            label1.setBounds(0, 0, 100, 50);
            label2.setLocation(width - label2.getPreferredSize().width, 0);
            label2.setSize(label2.getPreferredSize());
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
        }

        @Override
        public void removeLayoutComponent(Component comp) {
        }
    }
    private static class ColorLabel extends JLabel {
        public ColorLabel(String text, Color color) {
            this.setText(text);
            this.setOpaque(true);
            this.setBackground(color);
            this.setPreferredSize(new Dimension(60, 30));
            this.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}
