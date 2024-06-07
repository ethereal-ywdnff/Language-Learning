public class VarParameterDetail {
    public static void main(String[] args) {
        E e = new E();
        e.b();
        EE ee = new EE();
        ee.test1();
        ee.test2(e);
    }
}

class EE {
    public void test1() {
        E e = new E();
        System.out.println("test1: " + e.age);
    }
    public void test2(E e) {
        System.out.println("test2: " + e.age);
    }
}

class E {
    int age;//no need to assign a value

    public void a() {
        int age = 0;//must be assigned a value
    }

    public void b() {
        int age = 21;
        System.out.println("the age is " + age);
    }
}
