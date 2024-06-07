package src.control;

import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame {
    public static void main(String[] args) {
        LabelEx frame = new LabelEx("colored label");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public LabelEx(String title) {
        super(title);
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        ColorLabel label1 = new ColorLabel("1", Color.YELLOW);
        ColorLabel label2 = new ColorLabel("2", Color.GREEN);
        ColorLabel label3 = new ColorLabel("3", Color.LIGHT_GRAY);
        ColorLabel label4 = new ColorLabel("4", Color.CYAN);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
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
