package abstract_;

public class AbstractDetail {
    public static void main(String[] args) {
        //抽象类不能被实例化
        //new A();
    }
}

//抽象类里可以没有抽象方法
abstract class A {
    public void cry() {
        System.out.println("cry");
    }
}

//一旦包含抽象方法，这个类就必须被申明为抽象类
//abstract只能用来修饰类和方法
abstract class B {
    //public abstract int n = 0;
    public abstract void hi();

}

abstract class C {
    public abstract void hi();
}
//要继承一个抽象类，要么实现抽象类的所有抽象方法，要么也申明为抽象类
abstract class D extends C {}
class E extends C{
    @Override
    public void hi() { }
}

//抽象方法不能使用private，static，final来修饰
abstract class F {
    //private abstract void eat();
    //public final abstract void run();
    //public static abstract void run();
}