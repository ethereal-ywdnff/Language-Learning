package demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ActionListener 监听，按钮每一次被点击，terminal里都会输出
 * 在按钮旁边加一个点击的时间
 */
public class MyDemo3 extends JFrame {
    //2
    JLabel timeLabel = new JLabel("00:00:00");

    public static void main(String[] args) {
        MyDemo3 frame = new MyDemo3("example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public MyDemo3(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JButton button = new JButton("test");
        panel.add(button);

        //3
        panel.add(timeLabel);

//        MyActionListener listener = new MyActionListener();
//        button.addActionListener(listener);
        button.addActionListener(new MyActionListener());
    }
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button has been clicked...");
            //1 取得当前的时间
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String time = sdf .format(new Date());
            System.out.println(time);
            //4 把时间传进去timeLabel
            timeLabel.setText(time);
        }
    }

}
