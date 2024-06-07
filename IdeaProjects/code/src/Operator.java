public class Operator {
    public static void main(String [] args) {
        for (int i=1; i<10; i*=2) {
            System.out.println(i);
        }

        System.out.println("");
        int a = 10;
        int b = 99;
        int result = a < b ? ++a : b--;
        System.out.println(result);
        System.out.println(a);

        int c = 10;
        int d = 99;
        int result1 = c < d ? c : d;
        System.out.println(result1);
    }
}
