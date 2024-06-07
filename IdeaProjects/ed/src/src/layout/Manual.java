package src.layout;

import javax.swing.*;
import java.awt.*;

public class Manual extends JFrame{
    public static void main(String[] args) {
        Manual frame = new Manual("manual layout");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public Manual(String title) {
        super(title);
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        ColorLabel label = new ColorLabel("aaa", Color.CYAN);

        //不使用布局器，使用手工布局
        panel.setLayout(null);
        panel.add(label);
        label.setBounds(150, 175, 100, 50);
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
