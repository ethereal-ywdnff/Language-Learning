package single_;

public class SingleTon {
    public static void main(String[] args) {
//        G instance = G.getInstance();
//        System.out.println(instance);

        System.out.println(G.m);//构造器都会被调用
    }
}

class G {
    private String name;
    public static int m = 999;
    private static G g = new G("hh");//2

    //如何保障我们只能创建一个G对象(单例模式-饿汉式)
    //1. 将构造器私有化
    //2. 在类的内部直接创建
    //3. 提供一个公共的static方法，返回g对象
    private G(String name) {
        System.out.println("constructor");
        this.name = name;
    }

    public static G getInstance() {
        return g;
    }

    @Override
    public String toString() {
        return "name = " + name;
    }
}
