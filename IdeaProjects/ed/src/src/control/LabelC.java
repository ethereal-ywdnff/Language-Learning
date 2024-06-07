package src.control;

import javax.swing.*;
import java.awt.*;

public class LabelC extends JFrame{
    public static void main(String[] args) {
        LabelC frame = new LabelC("check box");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    public LabelC(String title) {
        super(title);

        JPanel panel = new JPanel();
        this.setContentPane(panel);

        JLabel label = new JLabel();
        panel.add(label);

        label.setText("hello");
        label.setFont(new Font("Inter", Font.PLAIN, 28));//Font.BOLD粗体

        label.setForeground(new Color(0, 234, 255));//文字颜色

        label.setOpaque(true);//背景不透明
        label.setBackground(Color.yellow);//背景颜色

        label.setPreferredSize(new Dimension(160,130));//控件大小

        label.setHorizontalAlignment(SwingConstants.CENTER);//水平方向上居中对齐
//        label.setHorizontalAlignment(SwingConstants.LEFT);
    }
}
