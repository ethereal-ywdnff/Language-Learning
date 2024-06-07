package innerclass;

/**
 * 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Out01 out01 = new Out01();
        out01.method();
    }
}

class Out01 {
    public void method() {
        //tiger的编译类型是IA，运行类型就是匿名内部类(Out01$1)
        //jdk底层创建内部类Out01$1，立即创建了Out01$1实例，并把地址返回给了tiger
        //匿名内部类只能使用一次(tiger是对象可以使用多次)
        IA tiger = new IA() {
            @Override
            public void cry() {
                System.out.println("tiger is crying");
            }
        };
        tiger.cry();
        System.out.println();

        //father的编译类型是Father，运行类型是Out01$2
        Father father = new Father("tom") {
            @Override
            public void test() {
                System.out.println("override the method test");
            }
        };
        father.test();
        System.out.println();

        //抽象类的匿名内部类
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println("animals are eating");
            }
        };
        animal.eat();
    }
}

interface IA {
    public void cry();
}

class Father {
    public Father(String name) {
        System.out.println("name: " + name);
    }

    public void test() {

    }
}

abstract class Animal {
    public void eat(){}
}