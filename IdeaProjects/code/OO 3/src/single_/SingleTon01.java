package single_;

public class SingleTon01 {
    public static void main(String[] args) {
        //System.out.println(Cat.m);//构造器不会被调用
        Cat instance = Cat.getInstance();
        System.out.println(instance);
    }
}

class Cat {
    private String name;
    public static int m = 999;
    private static Cat cat;

    //如何保障我们只能创建一个G对象(单例模式-懒汉式)
    //1. 将构造器私有化
    //2. 定义一个static静态属性对象
    //3. 提供一个公共的static方法，返回一个Cat对象
    //懒汉式，只有当用户使用getInstance时，才返回Cat对象
    private Cat(String name) {
        System.out.println("constructor");
        this.name = name;
    }
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("cutty");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "name = " + name;
    }
}