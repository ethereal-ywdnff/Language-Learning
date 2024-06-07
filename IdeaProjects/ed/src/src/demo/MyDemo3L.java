package src.demo;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 同MyDemo3 用lambda
 */
public class MyDemo3L extends JFrame{
    JLabel timeLabel = new JLabel("00:00:00");

    public static void main(String[] args) {
        MyDemo3L frame = new MyDemo3L("example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public MyDemo3L(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JButton button = new JButton("test");
        panel.add(button);

        //3
        panel.add(timeLabel);

        button.addActionListener((e -> {
            System.out.println("button has been clicked");
            showTime();
        }));
    }
    public void showTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf .format(new Date());
        System.out.println(time);

        timeLabel.setText(time);
    }
}
