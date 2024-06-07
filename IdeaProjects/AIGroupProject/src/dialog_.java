import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class dialog_ extends JFrame {
    String url = "jdbc:mysql://127.0.0.1:3306/team10";
    String uname = "team10";
    String password = "Ikun123456";

    public dialog_() {
        setTitle("Question");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            Connection connection = DriverManager.getConnection(url, uname, password);

        String query = "select * from questions_info where id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, 1);
        ResultSet rs = preparedStatement.executeQuery();
        String question = "";
        String ans1 = "";
        String ans2 = "";
        String ans3 = "";
        String ans4 = "";
        if (rs.next()) {
            question = rs.getString("content");
            ans1 = rs.getString("correct_answer");
            ans2 = rs.getString(5);
            ans3 = rs.getString(6);
            ans4 = rs.getString(7);
        } else {
            System.out.println("sorry, wrong info");
        }

        JPanel topPanel = new JPanel(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;

        JLabel questionLabel = new JLabel("<html><div style='text-align: center'>" + question + "</div></html>");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 20));
        questionLabel.setPreferredSize(new Dimension(200, 80));
        topPanel.add(questionLabel, gbc);

        try {
            BufferedImage image = ImageIO.read(new File("images/kun.png"));
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(-1, 100, Image.SCALE_SMOOTH));
            JLabel imageLabel = new JLabel(imageIcon);
            gbc.gridx = 1;
            gbc.weightx = 0.5;
            gbc.anchor = GridBagConstraints.EAST;
            topPanel.add(imageLabel, gbc);
            topPanel.add(imageLabel, gbc);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        add(topPanel, BorderLayout.NORTH);

        JPanel answerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ButtonGroup answerGroup = new ButtonGroup();

        JRadioButton answer1 = new JRadioButton(ans1);
        answer1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer1.setPreferredSize(new Dimension(150, 40));
        answer1.setFont(new Font("Arial", Font.BOLD, 16));
        JRadioButton answer2 = new JRadioButton(ans2);
        answer2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer2.setPreferredSize(new Dimension(150, 40));
        answer2.setFont(new Font("Arial", Font.BOLD, 16));
        JRadioButton answer3 = new JRadioButton(ans3);
        answer3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer3.setPreferredSize(new Dimension(150, 40));
        answer3.setFont(new Font("Arial", Font.BOLD, 16));
        JRadioButton answer4 = new JRadioButton(ans4);
        answer4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer4.setPreferredSize(new Dimension(150, 40));
        answer4.setFont(new Font("Arial", Font.BOLD, 16));

        answerGroup.add(answer1);
        answerGroup.add(answer2);
        answerGroup.add(answer3);
        answerGroup.add(answer4);

        answerPanel.add(answer1);
        answerPanel.add(answer2);
        answerPanel.add(answer3);
        answerPanel.add(answer4);

        add(answerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("SUBMIT");
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
        connection.close();
        preparedStatement.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new dialog_();
    }
}


