public class Test {
    int count = 9;

    public void count1() {
        count = 10;
        System.out.println("count1= " + count);
    }
    public void count2() {
        System.out.println("count2= " + count++);
    }

    public static void main(String[] args) {
        new Test().count1();//Anonymous objects that can't be used after one use

        Test t = new Test();
        t.count2();
        t.count2();
        System.out.println(t.count);
    }
}

class Demo{
    int i = 100;
    int j;
    public void m() {
        j = i++;
        System.out.println("i=" + i);
        System.out.println("j=" + j);
    }
}
class Test1{
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = d1;
        d2.m();
        System.out.println(d1.i);
        System.out.println(d2.j);
    }
}
