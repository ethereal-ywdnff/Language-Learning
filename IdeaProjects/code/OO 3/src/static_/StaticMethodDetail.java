package static_;

public class StaticMethodDetail {
}

class Detail {
    int n1 = 0;
    public static int n2 = 0;
    public void a() {//普通方法可以访问静态成员(属性和方法)和非静态成员
        System.out.println(n1);
        System.out.println(n2);
        b();
    }

    //静态方法只能访问静态成员
    //不能用super和this
    public static void b() {
        //a();//wrong
        //System.out.println(n1);//wrong
        System.out.println(n2);
        //System.out.println(this.n2);//wrong
    }
}
