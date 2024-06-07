import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        setTitle("my first frame");
        setSize(300,200);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//弹窗关闭的同时，程序也会关闭
        setVisible(true);//默认为false，就会不可见

        JButton button = new JButton("press");
        Container contentPanel = getContentPane();
        contentPanel.add(button);
    }
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setResizable(false);//设置弹窗大小固定
    }
}
