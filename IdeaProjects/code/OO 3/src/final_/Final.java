package final_;

public class Final {
    public static void main(String[] args) {
        //A.M = 10;
    }
}

//final用来修饰类，该类就不能被继承
final class A {
    //常量(直接赋值，在构造器中赋值，在代码块中赋值)
    public final int M = 1;
    public final int N;
    public final int S;

    public A() {
        N = 2;
    }

    {
        S = 3;
    }

    //final修饰的属性是静态时(直接直接赋值，在静态代码块里赋值)
    public static final int X = 1;
    public static final int Y;
    static {
        Y = 2;
    }
}
//class B extends A {}
class C {
    //final用来修饰方法，该方法就不能被重写
    public final void hi() {}
}
class D extends C {
    /*@Override
    public void hi() {
        System.out.println("override");
    }*/
}