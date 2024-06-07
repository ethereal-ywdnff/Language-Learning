package Object;

public class Equals {
    public static void main(String[] args) {
//        A a = new A();
//        A b = a;
//        A c = b;
//        System.out.println(a == c);
//        System.out.println(b == c);
//
//        B bb = a;
//        System.out.println(bb == b);
//        System.out.println(10 == 10.0);

        //==:是否为同一对象，equals:值是否相同(object的equals是"=="，比较两者是否为同一对象)
        Integer i = 1000;
        Integer j = 1000;
        System.out.println(i == j);
        System.out.println(i.intValue() == j.intValue());
        System.out.println(i.equals(j) + "\n");

        String s = new String("lkh");
        String t = new String("lkh");
        System.out.println(s == t);
        System.out.println(s.equals(t));

    }
}

class A extends B {}

class B {}