public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {24, 69, 80, 57, 13};
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println("\nround" + (i + 1));
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }

        }
    }
}
