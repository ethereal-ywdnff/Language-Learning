package src.control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBox extends JFrame{

    JComboBox<String> colorField = new JComboBox<>();

    public static void main(String[] args) {
        ComboBox frame = new ComboBox("check box");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public ComboBox(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        panel.add(colorField);
        colorField.addItem("red");
        colorField.addItem("green");
        colorField.addItem("blue");
        colorField.setSelectedIndex(1);//初始选择第二项 green

        JButton button = new JButton("test");
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test();
            }
        });
    }
    public void test() {
        int count = colorField.getItemCount();//获取数据项的个数
        String value = colorField.getItemAt(0);//获得单个数据项，第一项是什么
        System.out.println(count + " " + value);
        int index = colorField.getSelectedIndex();
        System.out.println(index);//当前选中的项
    }
}
