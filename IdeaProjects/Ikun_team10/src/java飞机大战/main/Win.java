package java飞机大战.main;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Win extends JFrame {
    public Win() {
        setTitle("Win");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(580, 195);
        setLocationRelativeTo(null);

        // Create the center panel with the 6 items and their values in a 2x3 grid
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/team10";
            String uname = "team10";
            String password = "Ikun123456";
            Connection connection = DriverManager.getConnection(url, uname, password);

            String sql = "select * from players_info where player_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "test");
            ResultSet resultSet = preparedStatement.executeQuery();
            int easy_right = 0;
            int medium_right = 0;
            int hard_right = 0;
            int easy_wrong = 0;
            int medium_wrong = 0;
            int hard_wrong = 0;
            if (resultSet.next()) {
                easy_right = resultSet.getInt("easy_right");
                medium_right = resultSet.getInt("medium_right");
                hard_right = resultSet.getInt("hard_right");
                easy_wrong = resultSet.getInt("easy_wrong");
                medium_wrong = resultSet.getInt("medium_wrong");
                hard_wrong = resultSet.getInt("hard_wrong");
            }

            String badge = null;
            if (easy_right == 10 && medium_right == 10 && hard_right == 10){
                badge = "You gain the Golden Badge. Perfect!";
            } else if (easy_right == 10 && medium_right == 10) {
                badge = "You gain the Silver Badge. Excellent!";
            } else if (easy_right == 10) {
                badge = "You gain the Bronze Badge. Well done!";
            } else {
                badge = "Unfortunately, no badge, keep up the good work(:";
            }

            // Create the top panel with the word "WIN"
            JPanel topPanel = new JPanel();
            JLabel winLabel = new JLabel("<html><div style='text-align: center'>Congratulations!" +
                    "<br>You WIN !!!<br>" + badge + "</div></html>");
            winLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
            topPanel.add(winLabel);

            JPanel centerPanel = new JPanel(new GridLayout(2, 3));
            String[] items = {"Easy Right", "Medium Right", "Hard Right", "Easy Wrong", "Medium Wrong", "Hard Wrong"};
            int[] values = {easy_right, medium_right, hard_right, easy_wrong, medium_wrong, hard_wrong};
            for (int i = 0; i < items.length; i++) {
                JLabel itemLabel = new JLabel(items[i] + ": ");
                JLabel valueLabel = new JLabel(Integer.toString(values[i]));
                JPanel itemPanel = new JPanel();
                itemPanel.add(itemLabel);
                itemPanel.add(valueLabel);
                centerPanel.add(itemPanel);
            }

            JPanel bottomPanel = new JPanel(new GridLayout(3, 4));
            String[] levels = {"  Gold Badge", "  Silver Badge", "  Bronze Badge"};
            String[] easyRights = {"10", "10", "10"};
            String[] mediumRights = {"10", "10", "0"};
            String[] hardRights = {"10", "0", "0"};
            for (int i = 0; i < levels.length; i++) {
                JLabel levelLabel = new JLabel(levels[i]);
                JLabel easyLabel = new JLabel("Easy Right: " + easyRights[i]);
                JLabel mediumLabel = new JLabel("Medium Right: " + mediumRights[i]);
                JLabel hardLabel = new JLabel("Hard Right: " + hardRights[i]);
                bottomPanel.add(levelLabel);
                bottomPanel.add(easyLabel);
                bottomPanel.add(mediumLabel);
                bottomPanel.add(hardLabel);
            }

            // Add the panels to the main JFrame
            add(topPanel, BorderLayout.NORTH);
            add(centerPanel, BorderLayout.CENTER);
            add(bottomPanel, BorderLayout.SOUTH);

            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Show the JFrame
        setVisible(true);
    }
}
