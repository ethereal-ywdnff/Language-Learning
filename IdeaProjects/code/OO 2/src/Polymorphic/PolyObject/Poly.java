package Polymorphic.PolyObject;

public class Poly {
    public static void main(String[] args) {
        Animal animal = new Dog();//编译类型是Animal，运行类型是Dog
        animal.cry();

        animal = new Cat();//编译类型是Animal，运行类型是Dog
        animal.cry();
    }
}
