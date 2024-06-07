package src.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 通过按钮把输入的字输出到terminal
 */
public class TextField extends JFrame {
    //添加文本框控件
    JTextField text = new JTextField(20);//20个字母的宽度

    public static void main(String[] args) {
        TextField frame = new TextField("text field");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public TextField(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.add(text);
        text.setText("default text field");

        JButton button = new JButton("submit");
        panel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
            }
        });
    }
    public void test() {
        String str = text.getText();
        System.out.println(str);
    }
}
