package manu;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class QuizApp extends JFrame {
    public QuizApp() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create a panel to hold the question and image label
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;

        // Create a label for the question
        JLabel questionLabel = new JLabel("<html><div style='text-align: center'>What is the capital of France?<br>Can you name it?</div></html>");
        questionLabel.setPreferredSize(new Dimension(200, 80));
        topPanel.add(questionLabel, gbc);

        // Create a label for the image and set its icon
        try {
            BufferedImage image = ImageIO.read(new File("images/kun.png"));
            ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(-1, 100, Image.SCALE_SMOOTH));
            JLabel imageLabel = new JLabel(imageIcon);
            gbc.gridx = 1;
            gbc.weightx = 0.5;
            gbc.anchor = GridBagConstraints.EAST;
            topPanel.add(imageLabel, gbc);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        add(topPanel, BorderLayout.NORTH);

        JPanel answerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ButtonGroup answerGroup = new ButtonGroup();

        JRadioButton answer1 = new JRadioButton("London");
        answer1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer1.setPreferredSize(new Dimension(150, 40));
        JRadioButton answer2 = new JRadioButton("Madrid");
        answer2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer2.setPreferredSize(new Dimension(150, 40));
        JRadioButton answer3 = new JRadioButton("Paris is the capital of France");
        answer3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer3.setPreferredSize(new Dimension(150, 40));
        JRadioButton answer4 = new JRadioButton("Rome");
        answer4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        answer4.setPreferredSize(new Dimension(150, 40));

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
        JButton submitButton = new JButton("Submit");
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Create a label for the AI sentence
        JLabel aiLabel = new JLabel("<html>This is about AI, \nfrom the link: https://ai.com<br></html>");
        aiLabel.setHorizontalAlignment(JLabel.CENTER);
        add(aiLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new QuizApp();
    }
}
