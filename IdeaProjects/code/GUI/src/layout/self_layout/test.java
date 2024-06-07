package layout.self_layout;

import javax.swing.*;
import java.awt.*;

public class test extends JFrame{
    ColorLabel label1 = new ColorLabel("aaa", Color.yellow);
    ColorLabel label2 = new ColorLabel("bbb", Color.green);
    ColorLabel label3 = new ColorLabel("ccc", Color.lightGray);
    ColorLabel label4 = new ColorLabel("ddd", Color.CYAN);
    ColorLabel label5 = new ColorLabel("eee", Color.red);

    public test() {
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.setLayout(new SimpleLayout());

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(label5);
    }
    public static void main(String[] args) {
        test frame = new test();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
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
