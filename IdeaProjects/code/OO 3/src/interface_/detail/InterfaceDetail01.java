package interface_.detail;

public class InterfaceDetail01 {
    public static void main(String[] args) {
        System.out.println(B.a);
        //B.a = 20;//a是final的
    }
}
//接口只能用public和默认修饰符
interface B {
    int a = 10;//实际上是public static final a = 10
}
interface C {}

//一个类可以实现多个接口
class Pig implements B, C {}

//接口不能继承类，但能继承多个接口
interface D extends B, C {}