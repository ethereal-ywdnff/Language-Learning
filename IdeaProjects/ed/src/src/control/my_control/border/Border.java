package src.control.my_control.border;

import javax.swing.*;
import java.awt.*;

public class Border extends JLabel{
        public void ColorLabel(String text, Color color) {
            this.setText(text);
            this.setOpaque(true);
            this.setBackground(color);
            this.setPreferredSize(new Dimension(60, 30));
            this.setHorizontalAlignment(SwingConstants.CENTER);
        }

}
