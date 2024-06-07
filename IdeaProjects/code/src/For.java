public class For {
    public static void main(String[] args) {
        int i = 0;
        for (; i <= 10; ) {
            i++;
        }
        System.out.println(i);

        int b = 0;
        for (int a = 0; a <= 10; a++) {
            b = a;
        }
        System.out.println(b);

        int c = 0, d = 0;
        for (int x = 0, y = 0; x < 3; x++, y += 2) {
            c = x;
            d = y;
        }
        System.out.println(c + " " + d);
    }
}
