package Extend.E;

public class Extend {
    public static void main(String[] args) {
        Pupil pupil = new Pupil();
        pupil.name = "tom~";
        pupil.age = 11;
        pupil.testing();
        pupil.setScore(91);
        pupil.showInfo();

        System.out.println("-----------------");
        Graduate graduate = new Graduate();
        graduate.name = "tim~";
        graduate.age = 22;
        graduate.testing();
        graduate.setScore(92);
        graduate.showInfo();
    }
}
