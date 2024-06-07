package java飞机大战.main;

public class Main {
    static GameFrame f1;
    static Sound sound;

    public static void main(String[] args) {
        new Clear();
        f1 = new GameFrame();
        f1.setDefaultCloseOperation(3);
        f1.setVisible(true);
        f1.setResizable(false);
//        if (sound == null) {
//            sound = new Sound("/sounds/back.wav");
//            sound.start();
//            sound.loop();
//        }
    }
}
