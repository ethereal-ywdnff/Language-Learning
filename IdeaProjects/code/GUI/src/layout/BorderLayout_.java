package layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayout_ extends JFrame{
    public static void main(String[] args) {
        BorderLayout_ frame = new BorderLayout_("colored label");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public BorderLayout_(String title) {
        super(title);
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        ColorLabel label1 = new ColorLabel("1", Color.YELLOW);
        ColorLabel label2 = new ColorLabel("2", Color.GREEN);
        ColorLabel label3 = new ColorLabel("3", Color.LIGHT_GRAY);
        ColorLabel label4 = new ColorLabel("4", Color.CYAN);
        ColorLabel label5 = new ColorLabel("5", Color.RED);

        panel.setLayout(new BorderLayout());
        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.SOUTH);
        panel.add(label3, BorderLayout.WEST);
        panel.add(label4, BorderLayout.EAST);
        panel.add(label5, BorderLayout.CENTER);

        label1.setPreferredSize(new Dimension(0, 100));//把label1的高度调高一点
        label3.setPreferredSize(new Dimension(100, 0));//把label1的宽度调高一点

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
