public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(-1));
    }

    public static int fibonacci(int a) {
        if (a >0) {
            if (a == 1 || a == 2) {
                return 1;
            } else {
                return fibonacci(a - 1) + fibonacci(a - 2);
            }
        }
        System.out.print("enter a number that bigger than ");
        return 0;
    }
}
