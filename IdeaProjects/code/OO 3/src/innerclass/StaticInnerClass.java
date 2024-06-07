package innerclass;

public class StaticInnerClass {
    public static void main(String[] args) {
        Out04 out04 = new Out04();
        out04.m1();

        //外部其他类 使用静态内部类
        //第一种方式 静态内部类可以直接通过类名来访问
        Out04.In04 in04 = new Out04.In04();
        in04.say();
        //第二种方式
        Out04.In04 in03Instance = out04.getIn03Instance();
        in03Instance.say();
    }
}

class Out04 {
    private int n1 = 10;
    private static String name = "tom";
    //可以直接访问外部的任何静态成员，但不能直接访问非静态的成员
    //可以添加任意的访问修饰符
    static class In04 {
        private static String name = "jack";
        public void say() {
            //如果外部类和局部外部类的成员重名了，默认就近原则，如果想用外部类的，则用外部类名.this.成员去访问
            System.out.println(name);
            System.out.println(Out04.name);
        }
    }

    public In04 getIn03Instance() {
        return new In04();
    }

    //创建访问静态内部类的方法
    public void m1() {
        In04 in04 = new In04();
        in04.say();
    }
}
