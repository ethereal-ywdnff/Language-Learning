package exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetail {
    public static void main(String[] args) {

    }

    //对于运行市异常，如果程序中没有处理，默认throws处理
    public void f2() {
    }

    public static void f3() throws FileNotFoundException {
        //1. 因为f4()方法抛出的是一个编译异常
        //2. 即这时，就要f3()必须处理这个编译异常
        //3. 在f3()中，要么try-catch-finally,或者继续throws这个编译异常
        f4();
    }
    public static void f4() throws FileNotFoundException {
        FileInputStream file = new FileInputStream("d://aa/txt");
    }

    public static void f5() {
        //1. 在f5()中调用方法f6()是0K的，原因是f6()抛出的是运行异常
        //2. 而java中，并不要求程序员显示处理，因为有默认处理机制
        //3. f6()是Exception或者编译异常时需要在f5()后写出来
        f6();
    }
    public static void f6() throws RuntimeException {}
}

class Father {
    public void method() throws RuntimeException{}
}

class Son extends Father{
    //子类重写父类的方法时，对抛出异常的规定：
    //子类重写的方法，所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
    @Override
    public void method() throws ArithmeticException {}
}

