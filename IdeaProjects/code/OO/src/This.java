public class This {
    public static void main(String[] args) {
        T t1 = new T();
        t1.m2();
        System.out.println();

        T t2 = new T();
        t2.m();
    }
}

class T {
    //property
    String name = "Jack";
    int age = 3;

    public T() {
        this("Tom", 23);//if it's "this", must put it in the first line
        System.out.println("T() constructor");
    }
    public T(String name, int age) {
        System.out.println(name +" " + age);
    }
    public void m() {
        String name = "Jim";
        //Proximity principle(don't have parameter in the method, then use the property)
        System.out.println("name: " + name + ", age: " + age);
        System.out.println("name: " + this.name + ", age: " + this.age);//property
    }

    public void m1() {
        System.out.println("m1() is invoked");
    }

    public void m2() {
        System.out.println("m2() is invoked");
        //invoke m1()
        m1();
        this.m1();
    }
}