package control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBox extends JFrame{

    JCheckBox box = new JCheckBox("agree");
    JButton button = new JButton("next");

    public static void main(String[] args) {
        CheckBox frame = new CheckBox("check box");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public CheckBox(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.add(box);
        box.setSelected(false);//默认勾选的状态

        panel.add(button);

        //按钮最开始是禁用的状态，勾选了后才能点击
        button.setEnabled(false);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.isSelected())
                    button.setEnabled(true);
                else
                    button.setEnabled(false);

            }
        });
    }
}
