package Extend;

public class Extend {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "tom";
        pupil.age = 10;
        pupil.testing();
        pupil.setScore(99);
        pupil.showInfo();

        System.out.println("-----------------");
        Graduate graduate = new Graduate();
        graduate.name = "tim";
        graduate.age = 20;
        graduate.testing();
        graduate.setScore(98);
        graduate.showInfo();

    }
}
