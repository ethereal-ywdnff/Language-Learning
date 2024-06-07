package innerclass;

public class AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Out02 out02 = new Out02();
        out02.f1();
    }
}

class Out02 {
    private int n1 = 10;
    public void f1() {
        //不能用修饰符
        Person person = new Person() {
            @Override
            public void hi() {
                System.out.println("anonymous inner class overrides the hi()");
            }
        };
        person.hi();

        new Person() {
            @Override
            public void ok(String name) {
                int n1 = 99;
                //如果外部类和局部外部类的成员重名了，默认就近原则，如果想用外部类的，则用外部类名.this.成员去访问
                System.out.println("n1= " + n1);
                System.out.println("outter n1= " + Out02.this.n1);
                super.ok(name);
            }
        }.ok("tom");
    }
}

class Person {
    public void hi() {
        System.out.println("Person.hi()");
    }

    public void ok(String name) {
        System.out.println("Person.ok() " + name);
    }
}