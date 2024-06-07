package abstract_;

public class Abstract {
}

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //抽象方法就是没有实现的方法(没有方法体的方法)
    /*public void eat() {
        System.out.println("don't know what to eat");
    }*/
    public abstract void eat() ;
}
