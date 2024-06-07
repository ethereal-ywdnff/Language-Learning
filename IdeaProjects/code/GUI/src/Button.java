import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JFrame implements ActionListener {
    JButton button;
    public Button() {
        setTitle("button");
        setSize(300,200);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        button = new JButton("press");
        button.setBounds(100,60,100,50);
        button.setText("click");
        button.addActionListener(this);
        //button.addActionListener(e -> System.out.println("sss"));//可以不用implements ActionListener和
                                                                 //override actionPerformed就能输出"sss"
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("yyy");
        }
    }

    public static void main(String[] args) {
        new Button();
    }
}
