public class Constructor {
    public static void main(String[] args) {
        Tom t1 = new Tom("Tom", 10);
        Tom t2 = new Tom(10);
        System.out.println(t1.name + " " + t1.age);
        System.out.println(t2.age);
    }
}

class Dog {

    /*
    default constructor:
    Dog() {

    }*/
}

class Tom {
    String name;
    int age;

    public Tom(String pName, int pAge) {
        name = pName;
        age = pAge;
    }
    public Tom(int pAge) {
        age = pAge;
    }

}
