package java飞机大战.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.*;
import javax.swing.*;

// Game start screen
public class GamePanel extends JPanel {
    static final int MAP_WIDTH = 1600;
    static final int MAP_HEIGHT = 1000;
    static long sum;//score
    static int time;
    static int live;// Player plane life
    private final int SCREEN_HEIGHT = 1000;// Screen height
    public int a = 1;
    int easy_right = 0;
    int medium_right = 0;
    int hard_right = 0;
    int easy_wrong = 0;
    int medium_wrong = 0;
    int hard_wrong = 0;
    private Image bg1, bg2, bg3, bg4, bg5, bg6, bg7, bg8, bg9, bg10;//Game background picture
    private int bg1_y, bg2_y, bg3_y, bg4_y, bg5_y, bg6_y, bg7_y, bg8_y, bg9_y, bg10_y;//The y coordinate of pictures
    private GameFrame gframe;
    private MapPanel jp;
    private boolean isRunning = false;
    private JButton start;
    private JLabel jl;
    private JLabel jb; //xin
    private JLabel ja;//xin
    private JLabel jright_easy;//xin
    private JLabel jright_medium;//xin
    private JLabel jright_hard;//xin
    private JLabel jwrong;//xin
    private JLabel jwrong_easy;//xin
    private JLabel jwrong_medium;//xin
    private JLabel jwrong_hard;//xin
    private Image x;
    //buffering
    private BufferedImage iBuffer;
    private Graphics gBuffer;

    public GamePanel(GameFrame gframe) {
        bg1_y = 0;
        bg2_y = -SCREEN_HEIGHT;
        bg3_y = -SCREEN_HEIGHT * 2;
        bg4_y = -SCREEN_HEIGHT * 3;
        bg5_y = -SCREEN_HEIGHT * 4;
        bg6_y = -SCREEN_HEIGHT * 5;
        bg7_y = -SCREEN_HEIGHT * 6;
        bg8_y = -SCREEN_HEIGHT * 7;
        bg9_y = -SCREEN_HEIGHT * 8;
        bg10_y = -SCREEN_HEIGHT * 9;


        this.gframe = gframe;
        setLayout(null);
        setPanel();
        live = 100;

    }

    public void setPanel() {
        sum = 0;//Set the initial score to zero
        start = new JButton("Start");
        start.setBounds(50, 60, 100, 50);
        add(start);

        start.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stop_start();
            }

        });


        // Set the label to store the score
        jl = new JLabel("0", JLabel.CENTER);
        jl.setBounds(50, 250, 100, 100);
        jl.setFont(new Font("acefont-family", Font.BOLD, 30));
        jl.setForeground(Color.red);
        this.add(jl);

        jb = new JLabel("0", JLabel.CENTER);
        jb.setBounds(0, 300, 200, 100);
        jb.setFont(new Font("acefont-family", Font.BOLD, 15));
        jb.setForeground(Color.red);
        this.add(jb);//new

        ja = new JLabel("0", JLabel.CENTER);
        ja.setBounds(50, 200, 100, 100);
        ja.setFont(new Font("acefont-family", Font.BOLD, 25));
        ja.setForeground(Color.red);
        this.add(ja);//new

        jright_easy = new JLabel("0", JLabel.CENTER);
        jright_easy.setBounds(0, 330, 200, 100);
        jright_easy.setFont(new Font("acefont-family", Font.BOLD, 15));
        jright_easy.setForeground(Color.red);
        this.add(jright_easy);//new

        jright_medium = new JLabel("0", JLabel.CENTER);
        jright_medium.setBounds(0, 360, 200, 100);
        jright_medium.setFont(new Font("acefont-family", Font.BOLD, 15));
        jright_medium.setForeground(Color.red);
        this.add(jright_medium);//new

        jright_hard = new JLabel("0", JLabel.CENTER);
        jright_hard.setBounds(0, 390, 200, 100);
        jright_hard.setFont(new Font("acefont-family", Font.BOLD, 15));
        jright_hard.setForeground(Color.red);
        this.add(jright_hard);//new

        jwrong = new JLabel("0", JLabel.CENTER);
        jwrong.setBounds(0, 450, 200, 100);
        jwrong.setFont(new Font("acefont-family", Font.BOLD, 15));
        jwrong.setForeground(Color.red);
        this.add(jwrong);//new

        jwrong_easy = new JLabel("0", JLabel.CENTER);
        jwrong_easy.setBounds(0, 480, 200, 100);
        jwrong_easy.setFont(new Font("acefont-family", Font.BOLD, 15));
        jwrong_easy.setForeground(Color.red);
        this.add(jwrong_easy);//new

        jwrong_medium = new JLabel("0", JLabel.CENTER);
        jwrong_medium.setBounds(0, 510, 200, 100);
        jwrong_medium.setFont(new Font("acefont-family", Font.BOLD, 15));
        jwrong_medium.setForeground(Color.red);
        this.add(jwrong_medium);//new

        jwrong_hard = new JLabel("0", JLabel.CENTER);
        jwrong_hard.setBounds(0, 540, 200, 100);
        jwrong_hard.setFont(new Font("acefont-family", Font.BOLD, 15));
        jwrong_hard.setForeground(Color.red);
        this.add(jwrong_hard);//new

        ImageIcon imcon = new ImageIcon(this.getClass().getResource("/images/score.jpeg"));
        JLabel jback = new JLabel(imcon);
        jback.setBounds(0, 0, 200, 1000);
        this.add(jback);

        jp = new MapPanel();
        jp.setBounds(200, 0, 1600, 1000);
        this.add(jp);

    }

    // Describe the map panel

    // Control thread start and pause
    public void stop_start() {
        if (isRunning) {
            // Stop the loop
            isRunning = false;
            start.setText("Start");

        } else {
            // Start the loop
            isRunning = true;
            // Create a thread
            Thread d = new Thread(jp);
            d.start();
            start.setText("Pause");
            jp.requestFocusInWindow();
        }
    }

    private class MapPanel extends Canvas implements Runnable {
        public MyPlane myplane;
        private EnemyPlane[] enemyarray;
        private Collision c;

        MapPanel() {
            bg1 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg1.jpeg"));
            bg2 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg2.jpeg"));
            bg3 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg3.jpeg"));
            bg4 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg4.jpeg"));
            bg5 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg5.jpeg"));
            bg6 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg6.jpeg"));
            bg7 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg7.jpeg"));
            bg8 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg8.jpeg"));
            bg9 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg9.jpeg"));
            bg10 = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/bg10.jpeg"));
            // Create player aircraft objects
            myplane = new MyPlane();

            myplane.adapter(this);//canvas add listener

            enemyarray = new EnemyPlane[10];

            for (int i = 0; i < enemyarray.length; i++) {
                enemyarray[i] = new EnemyPlane((-i - 1) * EnemyPlane.ENEMY_SIZE - Bullet.BULLET_HEIGHT);
            }

            c = new Collision();

            pauselistener();//To add a listener to the current game interface, press space to pause
        }

        @Override
        public void run() {

            while (isRunning) {
                draw();// Refresh the page
                try {
                    Thread.sleep(20);//delayed
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                time += 1;
                sum = time;

            }
        }

        public void paint(Graphics g) {
            try {
                String url = "jdbc:mysql://127.0.0.1:3306/team10";
                String uname = "team10";
                String password = "Ikun123456";
                Connection connection = DriverManager.getConnection(url, uname, password);

                String sql = "select * from players_info where player_name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "test");
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    easy_right = resultSet.getInt("easy_right");
                    medium_right = resultSet.getInt("medium_right");
                    hard_right = resultSet.getInt("hard_right");
                    easy_wrong = resultSet.getInt("easy_wrong");
                    medium_wrong = resultSet.getInt("medium_wrong");
                    hard_wrong = resultSet.getInt("hard_wrong");
                }

                //super.paint(g);
                //jl.setText("Score");//show score
                String s = "Score";
                ja.setText(s);
                jl.setText("" + sum);
                jb.setText("Question right: ");
                jright_easy.setText("easy: " + easy_right);
                jright_medium.setText("medium: " + medium_right);
                jright_hard.setText("hard: " + hard_right);
                jwrong.setText("Question wrong:");
                jwrong_easy.setText("easy: " + easy_wrong);
                jwrong_medium.setText("medium: " + medium_wrong);
                jwrong_hard.setText("hard: " + hard_wrong);

                //jl.setText("Wrong");

                if (sum >= 10000) {
                    start.setEnabled(false);
                    isRunning = false;
                    new Win();
                }
                if (sum % 300 == 0 && sum <= 3000 && sum >= 300) {
                    isRunning = false;
                    Thread.sleep(1000);
                    new Dialog("easy", "test");
                }
                if (easy_wrong >= 3) {
                    isRunning = false;
                    start.setEnabled(false);
                    new GameOver_3WrongAnswers();
                }
                if (sum % 300 == 0 && sum > 3000 && sum <= 6000) {
                    isRunning = false;
                    if (medium_wrong >= 3) {
                        new Dialog("easy", "test");
                    } else {
                        new Dialog("medium", "test");
                    }
                }
                if (sum % 300 == 0 && sum > 6000 && sum <= 9000) {
                    isRunning = false;
                    if (hard_wrong >= 3) {
                        isRunning = false;
                        new Dialog("medium", "test");
                    } else {
                        new Dialog("hard", "test");
                    }
                }


                if (iBuffer == null) {
                    iBuffer = new BufferedImage(1600, 1000, BufferedImage.TYPE_INT_RGB);
                    gBuffer = iBuffer.getGraphics();
                }
                gBuffer.drawImage(bg1, 0, bg1_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg2, 0, bg2_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg3, 0, bg3_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg4, 0, bg4_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg5, 0, bg5_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg6, 0, bg6_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg7, 0, bg7_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg8, 0, bg8_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg9, 0, bg9_y, MAP_WIDTH, MAP_HEIGHT, this);
                gBuffer.drawImage(bg10, 0, bg10_y, MAP_WIDTH, MAP_HEIGHT, this);

                myplane.drawMyPlane(gBuffer, this);


                if (!myplane.stayed && myplane.id == 5) {
                    start.setEnabled(false);
                    isRunning = false;
                    new GameOver_destroyed();
                }

                // Draw enemy planes
                for (int i = 0; i < enemyarray.length; i++) {
                    enemyarray[i].drawEnemy(gBuffer, this, i % 5);

                }

                if (live >= 0) {
                    // Draw the player plane
                    x = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/xue_" + ((100 - live) / 5 + 1) + ".png"));
                    gBuffer.drawImage(x, 7, 7, 200, 20, this);
                }

                Graphics canvasg = this.getGraphics();
                canvasg.drawImage(iBuffer, 0, 0, null);// Load the buffered image onto the screen

                connection.close();
                preparedStatement.close();
            } catch (SQLException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void draw() {
            mapMove();
            myplane.planeMove();
            // Enemy aircraft move
            for (int i = 0; i < enemyarray.length; i++) {
                enemyarray[i].enemyMove();
                c.plane_enemy(myplane, enemyarray[i]);// Enemy aircraft collision detection with player aircraft
            }

            repaint();
        }

        @Override
        public void update(Graphics g) {
            paint(g);
        }


        private void mapMove() {
            // moving of bg
            bg1_y += 1;
            bg2_y += 1;
            bg3_y += 1;
            bg4_y += 1;
            bg5_y += 1;
            bg6_y += 1;
            bg7_y += 1;
            bg8_y += 1;
            bg9_y += 1;
            bg10_y += 1;
            if (bg1_y == SCREEN_HEIGHT)
                bg1_y = -SCREEN_HEIGHT;
            if (bg2_y == SCREEN_HEIGHT)
                bg2_y = -SCREEN_HEIGHT;
            if (bg3_y == SCREEN_HEIGHT)
                bg3_y = -SCREEN_HEIGHT;
            if (bg4_y == SCREEN_HEIGHT)
                bg4_y = -SCREEN_HEIGHT;
            if (bg5_y == SCREEN_HEIGHT)
                bg5_y = -SCREEN_HEIGHT;
            if (bg6_y == SCREEN_HEIGHT)
                bg6_y = -SCREEN_HEIGHT;
            if (bg7_y == SCREEN_HEIGHT)
                bg7_y = -SCREEN_HEIGHT;
            if (bg8_y == SCREEN_HEIGHT)
                bg8_y = -SCREEN_HEIGHT;
            if (bg9_y == SCREEN_HEIGHT)
                bg9_y = -SCREEN_HEIGHT;
            if (bg10_y == SCREEN_HEIGHT)
                bg10_y = -SCREEN_HEIGHT;
        }


        private void pauselistener() {
            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (e.getKeyCode() == KeyEvent.VK_SPACE)
                        stop_start();

                }
            });
        }

    }


}
