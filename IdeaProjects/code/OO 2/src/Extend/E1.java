package Extend;

public class E1 {
    public static void main(String[] args) {
        B b = new B();
    }
}

class A {
    A() {
        System.out.println("a");
    }
    A(String name) {
        System.out.println("a name");
    }
}
class B extends A {
    B() {
        this("abc");
        System.out.println("b");
    }
    B(String name) {
        System.out.println("b name");
    }
}

