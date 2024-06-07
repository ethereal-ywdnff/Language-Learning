package interface_;

public class InterfaceVsExtends {
    public static void main(String[] args) {
        LittleMonkey wuKong = new LittleMonkey("wuKong");
        wuKong.climb();
        wuKong.swim();
        wuKong.fly();
    }
}

class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climb() {
        System.out.println(name + " is climbing");
    }

    public String getName() {
        return name;
    }
}

interface fish {
    void swim();
}
interface bird {
    void fly();
}

class LittleMonkey extends Monkey implements fish, bird{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " can swim after learning");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " can fly after learning");
    }
}