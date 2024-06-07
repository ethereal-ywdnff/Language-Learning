public class Overload {
    //requirement of overload
    //the method name must be the same
    //formal parameter cannot be the same(at least type of it or sequence of it is different)
    //return type is unnecessary
    public static void main(String[] args) {
        System.out.println(max(1,3));
        System.out.println(max(1.1,2.2));;
        System.out.println(max(1.1,2.2,3.3));
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    public static double max(double a, double b, double c) {
        double maxi = a > b ? a : b;
        return maxi > c ? maxi : c;
    }

    //these constitute the overload
    //void show() {}
    //int show(double a, int b) {}
    //int show(int a, double b) {}
}
