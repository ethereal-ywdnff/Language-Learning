package string_;

public class StringExercise {
    public static void main(String[] args) {
        //1.
//        String a = "abc";
//        String b = "abc";
//        System.out.println(a.equals(b));
//        System.out.println(a == b);

        //2.
//        String c = "abc";//c指向常量池中的"abc"
//        String d = new String("abc");//d指向堆中的对象"abc"
//        System.out.println(c.equals(d));
//        System.out.println(c == d);
//        //当调用intern方法时，如果池已经包含一个等于此String对象的字符串（用 equals(Object)方法确定),
//        //则返回池中的字符串。否则，将此String对象添加到池中，并返回此String对象的引用
//        System.out.println(c == d.intern());//d.intern()指向 c指向的常量池里的"abc"
//        System.out.println(d == d.intern());//所以d和d.intern()不一样

        //3.
        Person p1 = new Person();
        p1.name = "lkh";
        Person p2 = new Person();
        p2.name = "lkh";

        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name == p2.name);
        System.out.println(p1.name == "lkh");

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
    }
}

class Person {
    String name;
}
