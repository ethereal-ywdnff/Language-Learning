import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] a = {1, 2, 3};

        do {
            int[] b = new int[a.length + 1];
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i];
            }
            System.out.println("Please enter the number you want to add: ");
            int addNum = scanner.nextInt();
            //add the number into the array b
            b[b.length - 1] = addNum;
            //let array a point to array b
            a = b;
            System.out.println("a: ");
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("\nif you want to continue ");
            char key = scanner.next().toLowerCase().charAt(0);
            if (key == 'n') {
                System.out.println("exiting");
                break;
            }
        } while (true);
    }
}
