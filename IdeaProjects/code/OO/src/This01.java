public class This01 {
    public static void main(String[] args) {
        P p1 = new P("Tom", 9);
        P p2 = new P("Tim", 9);
        System.out.println("the result of p1 and p2 comparison: " + p1.compare(p2));
    }
}

class P {
    String name;
    int age;

    public P(String name, int age) {
        this.name= name;
        this.age = age;
    }
    public boolean compare(P p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}