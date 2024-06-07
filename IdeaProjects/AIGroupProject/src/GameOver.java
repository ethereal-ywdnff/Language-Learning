import javax.swing.*;

public class GameOver extends JFrame{
    public GameOver() {
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
        setLocationRelativeTo(null);
        JLabel label = new JLabel("<html><div style='text-align: center'>Game Over. You have answered 3 questions wrong.</div></html>", SwingConstants.CENTER);
        add(label);
        setSize(250, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new GameOver();
    }
}
