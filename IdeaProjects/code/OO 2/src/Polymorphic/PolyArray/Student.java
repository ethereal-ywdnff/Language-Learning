package Polymorphic.PolyArray;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + " score= " + score;
    }

    public void study() {
        System.out.println(getName() + " is studying");
    }
}
