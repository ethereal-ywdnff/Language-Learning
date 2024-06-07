package Extend;

public class Graduate {
    public String name;
    public int age;
    private double score;

    public void setScore(double score) {
        this.score = score;
    }

    public void testing() {
        System.out.println("graduate " + name + " is testing");
    }

    public void showInfo() {
        System.out.println(name + " " + age + " " + score);
    }
}
