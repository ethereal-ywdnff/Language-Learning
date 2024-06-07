package exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Throws {
    public static void main(String[] args) {

    }

    //使用throws,抛出异常，让调用f2方法的调用者（方法）处理
    //throws后面的异常类型可以是方法中产生的异常类型，也可以是它的父类(Exception)
    //throws关键字后也可以是异常列表，即可以抛出多个异常
    public void f1() throws FileNotFoundException, NullPointerException {
        FileInputStream file = new FileInputStream("d://aa/txt");
    }
}
