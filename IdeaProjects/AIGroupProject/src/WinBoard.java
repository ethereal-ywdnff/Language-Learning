import javax.swing.*;
import java.awt.*;

public class WinBoard extends JFrame {
    public WinBoard() {
        // Set up the main JFrame
        super("Board Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Create the top panel with the word "WIN"
        JPanel topPanel = new JPanel();
        JLabel winLabel = new JLabel("WIN");
        topPanel.add(winLabel);

        // Create the center panel with the 6 items and their values in a 2x3 grid
        JPanel centerPanel = new JPanel(new GridLayout(2, 3));
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6"};
        int[] values = {10, 20, 30, 40, 50, 60};
        for (int i = 0; i < items.length; i++) {
            JLabel itemLabel = new JLabel(items[i] + ": ");
            JLabel valueLabel = new JLabel(Integer.toString(values[i]));
            JPanel itemPanel = new JPanel();
            itemPanel.add(itemLabel);
            itemPanel.add(valueLabel);
            centerPanel.add(itemPanel);
        }

        // Add the panels to the main JFrame
        getContentPane().add(topPanel, "North");
        getContentPane().add(centerPanel, "Center");

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoardExample();
    }
}






