package exception_;

public class Exception {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            int c = a/b;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            //System.out.println("reason of the exception: " + e.getMessage());
        }
        System.out.println("--------");
    }
}
