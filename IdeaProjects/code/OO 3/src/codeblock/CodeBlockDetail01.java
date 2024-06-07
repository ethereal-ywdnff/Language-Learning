package codeblock;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        A a = new A();
    }
}

//静态代码块和静态属性初始化调用顺序按代码的顺序来执行
//普通代码块和普通属性初始化调用顺序按代码的顺序来执行
//先执行静态，在执行普通，然后是构造器
class A {
    public A() {
        System.out.println("A() is called");
    }

    private static int n1 = getN1();

    {
        System.out.println("normal");
    }

    private int n2 = getN2();

    public static int getN1() {
        System.out.println("getN1() is called");
        return 100;
    }

    static {
        System.out.println("static");
    }

    public int getN2() {
        System.out.println("getN2() is called");
        return 200;
    }
}
