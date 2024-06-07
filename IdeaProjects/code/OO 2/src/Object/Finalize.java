package Object;

public class Finalize {
    public static void main(String[] args) {
        Car bwm = new Car("bwm");
        bwm = null;
        System.gc();
    }
}

class Car {
    public String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + "car is destroyed");
    }
}
