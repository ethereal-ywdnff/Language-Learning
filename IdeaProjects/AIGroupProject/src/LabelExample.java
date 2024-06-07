import javax.swing.*;
import java.awt.*;

public class LabelExample extends JFrame {
    public LabelExample() {
        // Set up the main JFrame
        super("Label Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create a panel with a label that spans two rows
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JLabel label = new JLabel("<html>This text will<br>span two rows</html>");
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        panel.add(label, c);

        // Add the panel to the main JFrame
        getContentPane().add(panel, "Center");

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelExample();
    }
}

