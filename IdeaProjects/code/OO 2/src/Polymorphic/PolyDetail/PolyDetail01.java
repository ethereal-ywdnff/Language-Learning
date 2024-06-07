package Polymorphic.PolyDetail;

public class PolyDetail01 {
    public static void main(String[] args) {
        Base base = new Sub();//编译类型：Base，运行类型：Sub
        //方法调用看运行类型，属性调用看编译类型
        System.out.println(base.count);
        System.out.println(base.m1());
    }
}

class Base {
    int count = 10;

    public int m1() {
        return count;
    }
}

class Sub extends Base{
    int count = 20;

    public int m1() {
        return count;
    }
}
