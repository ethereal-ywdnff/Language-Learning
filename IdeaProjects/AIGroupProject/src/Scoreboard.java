import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Scoreboard extends JFrame {

    private Map<String, Integer> scores = new HashMap<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> scoreList = new JList<>(listModel);

    public Scoreboard() {
        setTitle("Scoreboard");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Increase font size of scoreList
        scoreList.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));

        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.add(new JLabel("Scores", SwingConstants.CENTER), BorderLayout.NORTH);
        scorePanel.add(new JScrollPane(scoreList), BorderLayout.CENTER);

        add(scorePanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // center the window on the screen

        setVisible(true);
    }

    private void updateScoreList() {
        listModel.clear();
        TreeMap<Score, String> sortedScores = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            Score key = new Score(score, name);
            sortedScores.put(key, name);
        }
        int rank = 1;
        for (Map.Entry<Score, String> entry : sortedScores.entrySet()) {
            Score score = entry.getKey();
            String name = entry.getValue();
            String scoreString = String.format("%d. %s: %d", rank++, name, score.getScore());
            listModel.addElement(scoreString);
        }
    }

    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.scores.put("Alice", 100);
        scoreboard.scores.put("Bob", 75);
        scoreboard.scores.put("Charlie", 50);
        scoreboard.scores.put("David", 80);
        scoreboard.scores.put("Eve", 75);
        scoreboard.scores.put("Frank", 80);
        scoreboard.scores.put("Tom", 80);
        scoreboard.scores.put("Tim", 80);
        scoreboard.scores.put("Amy", 80);
        scoreboard.updateScoreList();
    }

    private static class Score implements Comparable<Score> {
        private final int score;
        private final String name;

        public Score(int score, String name) {
            this.score = score;
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Score o) {
            int scoreDiff = o.score - this.score;
            if (scoreDiff != 0) {
                return scoreDiff;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}






