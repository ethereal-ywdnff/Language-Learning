package Polymorphic.Dynamic;

public class DynamicBinding {
    public static void main(String[] args) {
        //当调用对象方法时，该方法会和该对象的运行类型绑定(动态绑定机制)
        //当调用对象属性时，在哪个方法里申明就在使用哪个方法里的属性(没有动态绑定机制)
        A a = new B();
        System.out.println(a.sum());
        System.out.println(a.sum1());
    }
}

class A {
    public int i = 10;

    public int sum() {
        return getI() + 20;//20+20
        //去运行类型(子类)里找getI，所以这里的getI是子类里的getI，方法是看a的运行类型(B)
    }

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {
    public int i = 20;

    /*public int sum() {
        return i + 20;
    }*/

    public int sum1() {
        return i + 10;
    }

    public int getI() {
        return i;
    }
}