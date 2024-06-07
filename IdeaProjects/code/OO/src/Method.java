public class Method {
    public static void main(String[] args) {
        Person p = new Person();
        p.cal(10);
        int sum = p.getSum(10, 20);
        System.out.println(sum);

        A a = new A();
        a.m();
    }
}

class Person {
    public void cal(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("the result is " + sum);
    }

    public int getSum(int a, int b) {
        int res = a + b;
        return res;
    }
}

class A {
    public void m() {
        B b = new B();
        System.out.println("m() in process");
        b.n();
        System.out.println("end executing n()");
    }
}

class B {
    public void n() {
        System.out.println("n() in process");
    }
}