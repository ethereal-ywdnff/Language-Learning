public class OddOrEven {
    public static void main(String[] args) {
        int num = 2;
        if (isOdd(num)) {
            System.out.println("it's odd");
        } else {
            System.out.println("it's even");
        }
    }

    public static boolean isOdd(int a) {
        if (a % 2 == 0) {
            return false;
        } else {
            return true;
        }
        //return a % 2 != 0 ? true: false;
        //return a % 2 != 0;
    }
}

