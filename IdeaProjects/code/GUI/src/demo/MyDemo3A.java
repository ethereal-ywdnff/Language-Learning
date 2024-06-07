package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 同MyDemo3 用匿名内部类
 */
public class MyDemo3A extends JFrame {
    JLabel timeLabel = new JLabel("00:00:00");

    public static void main(String[] args) {
        MyDemo3A frame = new MyDemo3A("example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public MyDemo3A(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JButton button = new JButton("test");
        panel.add(button);

        //3
        panel.add(timeLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTime();
            }
        });
    }
    public void showTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf .format(new Date());
        System.out.println(time);

        timeLabel.setText(time);
    }
}
