public class EX {
    public static void main(String[] args) {
        Object o = true ? new Integer(1) : new Double(2);
        System.out.println(o);
    }
}

class A {
    int a = 10;
    public int getA() {
        return a++;
    }
}
