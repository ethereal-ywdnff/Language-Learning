package Polymorphic;

public class Poly {
    public static void main(String[] args) {
        Master tom = new Master("tom");
        Dog huang = new Dog("huang");
        Bone bone = new Bone("bone");

        tom.feed(huang, bone);

        System.out.println("==============================");
        Cat cat = new Cat("cat");
        Fish fish = new Fish("fish");
        tom.feed(cat,fish);
    }
}
