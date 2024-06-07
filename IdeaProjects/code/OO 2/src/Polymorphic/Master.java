package Polymorphic;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food) {
        System.out.println("master " + name + " feed " + animal.getName() + " with " + food.getName());
    }

    /*//feed dog
    public void feed(Dog dog, Bone bone) {
        System.out.println("master " + name + " feed " + dog.getName() + " with " + bone.getName());
    }

    //feed fish
    public void feed(Cat cat, Fish fish) {
        System.out.println("master " + name + " feed " + cat.getName() + " with " + fish.getName());
    }*/
}
