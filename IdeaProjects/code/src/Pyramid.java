public class Pyramid {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 4 - a; b++) {
                System.out.print(" ");
            }
            for (int c = 0; c < 2 * a + 1; c++) {
                if (c == 0 || c == 2 * a || a == 4) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
