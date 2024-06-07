package manu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

public class QuestionPage extends JFrame {
    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;

    public QuestionPage() {
        super("Question Page");

        // Create radio buttons for four answers
        answer1 = new JRadioButton("Answer 1");
        answer2 = new JRadioButton("Answer 2");
        answer3 = new JRadioButton("Answer 3");
        answer4 = new JRadioButton("Answer 4");

        // Create a button group to ensure only one answer is selected at a time
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(answer1);
        buttonGroup.add(answer2);
        buttonGroup.add(answer3);
        buttonGroup.add(answer4);

        // Create a submit button
        JButton submitButton = new JButton("Submit");

        // Add an action listener to the submit button to check the selected answer
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correctAnswer = "Answer 3";
                JRadioButton selectedButton = null;

                for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();

                    if (button.isSelected()) {
                        selectedButton = (JRadioButton) button;
                        break;
                    }
                }

                if (selectedButton != null && selectedButton.getText().equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(QuestionPage.this, "Correct!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(QuestionPage.this, "Incorrect.");
                }
            }
        });

        // Create a panel to hold the radio buttons and the submit button
        JPanel answerPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        answerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        answerPanel.add(answer1);
        answerPanel.add(answer2);
        answerPanel.add(answer3);
        answerPanel.add(answer4);
        answerPanel.add(submitButton);

        // Add the panel to the frame
        getContentPane().add(answerPanel, BorderLayout.CENTER);

        // Set the frame size and make it visible
        setSize(450, 450);
        setVisible(true);
    }

    public static void main(String[] args) {
        QuestionPage questionPage = new QuestionPage();
    }
}

