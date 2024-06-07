package java飞机大战.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;

public class Dialog extends JFrame {
    public Dialog(String difficulty, String name) {
        setTitle("QUESTION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(475, 475);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/team10";
            String uname = "team10";
            String password = "Ikun123456";
            Connection connection = DriverManager.getConnection(url, uname, password);

            String query = "select * from questions_info where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int question_number = 1;
            if (difficulty == "easy") {
                Random random = new Random();
                question_number = random.nextInt(10) + 1;
            } else if (difficulty == "medium") {
                Random random = new Random();
                question_number = random.nextInt(10) + 11;
            } else if (difficulty == "hard") {
                Random random = new Random();
                question_number = random.nextInt(10) + 21;
            }
            preparedStatement.setInt(1, question_number);
            ResultSet resultSets = preparedStatement.executeQuery();
            String question = "";
            String ans1 = "";
            String ans2 = "";
            String ans3 = "";
            String ans4 = "";
            String question_type = "";
            if (resultSets.next()) {
                question = resultSets.getString("content");
                ans1 = resultSets.getString("correct_answer");
                ans2 = resultSets.getString(5);
                ans3 = resultSets.getString(6);
                ans4 = resultSets.getString(7);
                question_type = resultSets.getString("question_type");
            } else {
                System.out.println("sorry, wrong info");
            }

            final String correct_answer = "<html><div style='text-align: center'>" + ans1 + "</div></html>";
            final String correct_answer2 = ans1;

            // Create a panel to hold the question and image label
            JPanel topPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.5;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.WEST;

            // Create a label for the question
            JLabel questionLabel = new JLabel("<html><div style='text-align: center'>" + question + "</div></html>");
            questionLabel.setPreferredSize(new Dimension(300, 150));
            questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
            topPanel.add(questionLabel, gbc);

            // Create a label for the image and set its icon
            BufferedImage image = ImageIO.read(new File("src/images/kun.png"));
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(-1, 100, Image.SCALE_SMOOTH));
            JLabel imageLabel = new JLabel(imageIcon);
            gbc.gridx = 1;
            gbc.weightx = 0.5;
            gbc.anchor = GridBagConstraints.EAST;
            topPanel.add(imageLabel, gbc);

            add(topPanel, BorderLayout.NORTH);

            JPanel answersPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            answersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            ButtonGroup answers = new ButtonGroup();

            JRadioButton answer1 = new JRadioButton("<html><div style='text-align: center'>" + ans1 + "</div></html>");
            answer1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JRadioButton answer2 = new JRadioButton("<html><div style='text-align: center'>" + ans2 + "</div></html>");
            answer2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JRadioButton answer3 = new JRadioButton("<html><div style='text-align: center'>" + ans3 + "</div></html>");
            answer3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            JRadioButton answer4 = new JRadioButton("<html><div style='text-align: center'>" + ans4 + "</div></html>");
            answer4.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            answers.add(answer1);
            answers.add(answer2);
            answers.add(answer3);
            answers.add(answer4);

            answersPanel.add(answer1);
            answersPanel.add(answer2);
            answersPanel.add(answer3);
            answersPanel.add(answer4);

            add(answersPanel, BorderLayout.CENTER);

            JLabel timeLabel = new JLabel("Time remaining: 30 seconds");
            int delay = 2000; // delay in milliseconds
            AtomicInteger remainingTime = new AtomicInteger(30); // remaining time in seconds
            Timer timer = new Timer(delay, e -> {
                remainingTime.getAndDecrement();
                timeLabel.setText(remainingTime + " seconds");
                if (remainingTime.get() == 0) {
                    ((Timer)e.getSource()).stop();
                    //dispose(); // close the window
                }
            });
            timer.start();

            JPanel bottomPanel = new JPanel();
            bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JRadioButton selectedButton = null;

                    for (Enumeration<AbstractButton> buttons = answers.getElements(); buttons.hasMoreElements();) {
                        AbstractButton button = buttons.nextElement();

                        if (button.isSelected()) {
                            selectedButton = (JRadioButton) button;
                            break;
                        }
                    }

                    if (selectedButton != null && selectedButton.getText().equals(correct_answer)) {
                        String sql = "select * from questions_info where correct_answer = ?";
                        String sql2 = "select * from players_info where player_name = ?";

                        int easy_right = 0;
                        int medium_right = 0;
                        int hard_right = 0;

                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1, correct_answer2);
                            ResultSet rs = preparedStatement.executeQuery();
                            String level = null;
                            if (rs.next()) {
                                level = rs.getString("difficulty_level");
                                if (level.equals("easy")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        easy_right = rs2.getInt("easy_right");
                                        easy_right += 1;
                                        String sql_er = "update players_info set easy_right = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_er);
                                        preparedStatement2.setInt(1, easy_right);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                                if (level.equals("medium")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        medium_right = rs2.getInt("medium_right");
                                        medium_right += 1;
                                        String sql_mr = "update players_info set medium_right = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_mr);
                                        preparedStatement2.setInt(1, medium_right);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                                if (level.equals("hard")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        hard_right = rs2.getInt("hard_right");
                                        hard_right += 1;
                                        String sql_hr = "update players_info set hard_right = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_hr);
                                        preparedStatement2.setInt(1, hard_right);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(Dialog.this, "Correct!");
                    } else {
                        String sql = "select * from questions_info where correct_answer = ?";
                        String sql2 = "select * from players_info where player_name = ?";

                        int easy_wrong = 0;
                        int medium_wrong = 0;
                        int hard_wrong = 0;

                        try {
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setString(1, correct_answer2);
                            ResultSet rs = preparedStatement.executeQuery();
                            String level = null;
                            if (rs.next()) {
                                level = rs.getString("difficulty_level");
                                if (level.equals("easy")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        easy_wrong = rs2.getInt("easy_wrong");
                                        easy_wrong += 1;
                                        String sql_ew = "update players_info set easy_wrong = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_ew);
                                        preparedStatement2.setInt(1, easy_wrong);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                                if (level.equals("medium")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        medium_wrong = rs2.getInt("medium_wrong");
                                        medium_wrong += 1;
                                        String sql_mw = "update players_info set medium_wrong = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_mw);
                                        preparedStatement2.setInt(1, medium_wrong);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                                if (level.equals("hard")) {
                                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
                                    preparedStatement1.setString(1, name);
                                    ResultSet rs2 = preparedStatement1.executeQuery();
                                    if (rs2.next()) {
                                        hard_wrong = rs2.getInt("hard_wrong");
                                        hard_wrong += 1;
                                        String sql_hw = "update players_info set hard_wrong = ? where player_name = ?";
                                        PreparedStatement preparedStatement2 = connection.prepareStatement(sql_hw);
                                        preparedStatement2.setInt(1, hard_wrong);
                                        preparedStatement2.setString(2, name);
                                        preparedStatement2.executeUpdate();
                                    }
                                }
                            }

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(Dialog.this, "Incorrect.");

                    }
                    dispose();
                }
            });

            JLabel desLabel = new JLabel("<html>This is a question about " + question_type + ", from the website: https://students.yourlearning.ibm.com</html>");
            desLabel.setFont(new Font(Font.SANS_SERIF,Font.PLAIN, 12));
//            desLabel.setHorizontalAlignment(JLabel.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(submitButton);
            bottomPanel.add(timeLabel);
            bottomPanel.add(buttonPanel);
            bottomPanel.add(Box.createVerticalStrut(20));
            bottomPanel.add(desLabel);
            add(bottomPanel, BorderLayout.SOUTH);


            setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}