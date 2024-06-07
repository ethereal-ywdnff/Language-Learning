package layout;

import javax.swing.*;
import java.awt.*;

public class HLayout_ extends JFrame{
    public static void main(String[] args) {
        BorderLayout_ frame = new BorderLayout_("colored label");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public HLayout_(String title) {
        super(title);
        JPanel panel = new JPanel();
        this.setContentPane(panel);

        //panel.setLayout(new HLayout());
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
