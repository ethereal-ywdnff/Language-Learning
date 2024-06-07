package innerclass;

/**
 * 成员内部类
 */
public class MemberInnerClass {
    public static void main(String[] args) {
        Out03 out03 = new Out03();
        out03.t1();

        //不用另写调用成员内部类的方法t1()
        //外部其他类 使用成员内部类
        //第一种方式
        Out03.In03 in03 = out03.new In03();
        in03.say();

        //第二种方式 在外部类中，编写一个方法，可以返回In03对象
        Out03.In03 in03Instance = out03.getIn03Instance();
        in03Instance.say();
    }
}

class Out03 {
    private int n1 = 10;
    public String name = "tom";
    public void hi() {
        System.out.println("hi()");
    }

    //可以添加任何的访问修饰符
    protected class In03 {
        private int a = 999;
        public void say() {
            //可以直接访问外部类的所有成员，包括私有的
            //如果外部类和局部外部类的成员重名了，默认就近原则，如果想用外部类的，则用外部类名.this.成员去访问
            System.out.println("n1= " + n1);
            System.out.println("name= " + name);
            hi();
        }
    }

    public In03 getIn03Instance() {
        return new In03();
    }

    //调用成员内部类的方法
    public void t1() {
        //创造成员内部类的对象，然后使用相关的方法
        In03 in03 = new In03();
        in03.say();
        System.out.println(in03.a);
    }
}
