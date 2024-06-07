package interface_.detail;

public class InterfaceDetail {
    public static void main(String[] args) {
        //new A();
    }
}
//接口不能被实例化
interface A {
    //接口里的是抽象方法，但加不加abstract都行
    //没有修饰符，都是默认public
    void start();
    public void stop();

    //默认方法，前面要加default
    default public void ok() {}

    //静态方法，前面加static
    public static void hi() {}
}

class Cat implements A {

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }
}

//抽象类实现接口可以不用实现接口的方法
abstract class Tiger implements A {}