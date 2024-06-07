import javax.swing.*;
import java.awt.*;

public class BoardExample extends JFrame {
    public BoardExample() {
        // Set up the main JFrame
        super("Board Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 200);

        // Create the top panel with the word "WIN"
        JPanel topPanel = new JPanel();
        JLabel winLabel = new JLabel("WIN");
        topPanel.add(winLabel);

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
//            centerPanel.add(itemLabel);
//            centerPanel.add(valueLabel);
        }

        // Create the center panel with the level information in a grid
        JPanel bottomPanel = new JPanel(new GridLayout(3, 4));
        String[] levels = {"Gold badge", "Silver badge", "Bronze badge"};
        String[] easyRights = {"10", "10", "10"};
        String[] mediumRights = {"10", "10", "0"};
        String[] hardRights = {"10", "0", "0"};
        for (int i = 0; i < levels.length; i++) {
            JLabel levelLabel = new JLabel(levels[i]);
            JLabel easyLabel = new JLabel("Easy: " + easyRights[i] + " right");
            JLabel mediumLabel = new JLabel("Medium: " + mediumRights[i] + " right");
            JLabel hardLabel = new JLabel("Hard: " + hardRights[i] + " right");
            JPanel levelPanel = new JPanel();
            bottomPanel.add(levelLabel);
            //bottomPanel.add(new JPanel()); // Add an empty panel for spacing
            bottomPanel.add(easyLabel);
            bottomPanel.add(mediumLabel);
            bottomPanel.add(hardLabel);
            //bottomPanel.add(new JPanel()); // Add another empty panel for spacing
//            levelPanel.add(levelLabel);
//            levelPanel.add(easyLabel);
//            levelPanel.add(mediumLabel);
//            levelPanel.add(hardLabel);
//            bottomPanel.add(levelPanel);
        }

        // Add the panels to the main JFrame
        getContentPane().add(topPanel, "North");
        getContentPane().add(centerPanel, "Center");
        getContentPane().add(bottomPanel, "South");

        // Show the JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new BoardExample();
    }
}



