package innerclass;

public class InnerClass {
}

class Outer {//外部类
    private int n1 = 100;

    public Outer(int n1) {
        this.n1 = n1;
    }
    public void m1() {
        System.out.println("m1()");
    }
    {
        System.out.println("codeblock");
    }
    class Inner {//内部类，在Outer内部

    }
}