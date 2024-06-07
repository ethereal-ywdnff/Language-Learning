package static_;

public class ChildGame {
    public static void main(String[] args) {
        Child tom = new Child("tom");
        tom.join();
        tom.count++;
        Child tim = new Child("tim");
        tim.join();
        tim.count++;

        //类变量可以通过类名来访问
        System.out.println(Child.count + " children join in the game");
        System.out.println(tom.count);
        System.out.println(tim.count);
    }
}

class Child {
    private String name;
    //静态变量: 会被Child类里所有的对象实例共享
    public static int count = 0;

    public Child(String name) {
        this.name = name;
    }

    public void join() {
        System.out.println(name + " joins in the game");
    }
}
