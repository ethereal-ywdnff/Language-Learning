package Polymorphic.PolyArray;

public class Poly {
    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0] = new Person("tom",20);
        persons[1] = new Student("tim",10,98);
        persons[2] = new Teacher("jon",30,40000);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());
            if (persons[i] instanceof Student) {
                ((Student)persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher)persons[i]).teach();
            } else {
                System.out.println("type is wrong");
            }
        }

    }
}
