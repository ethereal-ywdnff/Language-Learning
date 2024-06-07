import java.awt.*;
import javax.swing.*;

public class IkunGames extends JFrame {
   // 创建四个文本的label
    private JLabel welcomeLabel;
    private JLabel rulesLabel;
    private JLabel questionsLabel;
    private JLabel endingLabel;

    public IkunGames() {
        JFrame frame = new JFrame("Background Image ");
        setTitle("Ikun Games");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));
        
        ImageIcon imageIcon = new ImageIcon("Background.jpg"); // 背景图片路径
        JLabel backgroundLabel = new JLabel(imageIcon);
        add(backgroundLabel);
        Image image = imageIcon.getImage();


        // 开始写入文本
        welcomeLabel = new JLabel("Welcome to Ikun Games! In this game, you will take control of a high-speed spaceship and explore the galaxies of the interstellar world, travelling through the vastness of the universe while battling with meteorite computer titles.");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.WHITE); // 设置标签字体颜色
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 20)); // 设置标签字体和大小
        add(welcomeLabel);

        rulesLabel = new JLabel("The rules of the game are simple: use the arrow keys on the keyboard to control the movement of the ship, the up, down, left and right keys correspond to the forward, backward, left and right flight of the ship; use the spacebar to pause the game to ensure you can respond to unexpected events. You will need to stay alive for as long as possible, with computer questions appearing at regular intervals, and you will need to keep answering them correctly to keep the spaceship moving. Your spaceship will keep flying and during this time there will be obstacles and enemies coming at you from all directions. You will need to avoid collisions by dodging them and survive to earn points as a symbol of glory.");
        rulesLabel.setHorizontalAlignment(JLabel.CENTER);
        rulesLabel.setForeground(Color.WHITE); // 设置标签字体颜色
        rulesLabel.setFont(new Font("SansSerif", Font.PLAIN, 20)); // 设置标签字体和大小
        add(rulesLabel);

        questionsLabel = new JLabel("The questions to be answered are mainly from IBM's library of computer questions on programming languages, data structures, algorithms, principles of computer composition and more. There are three levels of questions and if you answer all the questions correctly at the appropriate level of difficulty, you will receive a medal for that level. However, if you get a certain number of questions wrong, or if you hit an obstacle or enemy several times, your voyage through the universe will stop and the game will end.");
        questionsLabel.setHorizontalAlignment(JLabel.CENTER);
        questionsLabel.setForeground(Color.WHITE); // 设置标签字体颜色
        questionsLabel.setFont(new Font("Monospaced", Font.ITALIC, 20)); // 设置标签字体和大小
        add(questionsLabel);

        endingLabel = new JLabel("Ikun is a fun and challenging game that allows you to improve your computer knowledge and skills while enjoying the thrill of sailing through the universe. Come and join us and become the strongest spaceship pilot!");
        endingLabel.setHorizontalAlignment(JLabel.CENTER);
        endingLabel.setForeground(Color.BLUE); // 设置标签字体颜色
        endingLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20)); // 设置标签字体和大小
        add(endingLabel);
    }

    public static void main(String[] args) {
      IkunGames ikun = new IkunGames();
      ikun.setVisible(true);
  }
}