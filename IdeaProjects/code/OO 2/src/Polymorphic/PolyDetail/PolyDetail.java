package Polymorphic.PolyDetail;

public class PolyDetail {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.run();
        animal.cry();
        //animal.catCatch();//wrong

        //父类的应用必须是指向的是当前目标类型的对象
        //Dog dog = (Dog) animal;//wrong
        Cat cat = (Cat) animal;
        cat.catCatch();
    }
}
