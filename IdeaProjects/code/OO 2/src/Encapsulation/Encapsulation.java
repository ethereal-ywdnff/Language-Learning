package Encapsulation;

public class Encapsulation {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Tom");
        p.setAge(12);
        p.setSalary(5555);
        System.out.println(p.info());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {};
    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 2 && name.length() < 6) {
            this.name = name;
        } else {
            System.out.println("please enter a proper name");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 1 && age < 100) {
            this.age = age;
        } else {
            System.out.println("please enter a proper age");
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "info: " + name + ", age: " + age + ", salary: " + +salary;
    }
}
