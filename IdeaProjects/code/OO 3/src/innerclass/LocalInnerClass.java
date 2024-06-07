package innerclass;

/**
 * 局部内部类
 */
public class LocalInnerClass {
    public static void main(String[] args) {
        Out out = new Out();
        out.m2();
    }
}

class Out {
    private int n1 = 100;
    public void m1() {
        System.out.println("Out.m1()");
    }
    public void m2() {
        //定义在外部类的局部位置，通常在方法
        //不能添加访问修饰符，但可以用final
        //这个内部类(In)的作用域只有在这个方法或者代码块中
        class In {
            //可以直接访问外部类的所有成员，包括私有的
            private int n1 = 200;
            public void f1() {
                //可以直接访问外部类的成员
                //如果外部类和局部外部类的成员重名了，默认就近原则，如果想用外部类的，则用外部类名.this.成员去访问
                System.out.println("n1= " + n1);
                System.out.println("Out: " + Out.this.n1);
                m1();
            }
        }
        In in = new In();
        in.f1();
    }
}