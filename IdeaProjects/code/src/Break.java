import java.util.Scanner;

public class Break {
    public static void main(String[] args) {
        label1:
        for (int i = 0; i < 3; i++) {
            label2:
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    break;
                }
                System.out.println("j= " + j);
            }
        }
        System.out.println();

        /*int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
            if (sum > 20) {
                System.out.println(sum);
                break;
            }
        }*/

        Scanner scanner = new Scanner(System.in);
        String name = "";
        String psd = "";
        int chance = 3;
        /*for (int i = 0; i < 3; i++) {
            System.out.println("enter your Name");
            name = scanner.next();
            System.out.println("enter your Password");
            psd = scanner.next();
            if ("kk".equals(name) && "666".equals(psd)){
                System.out.println("Congratulations!");
                break;
            }
            chance--;
            System.out.println("You still have " + chance + "chances!");
        }*/
    }
}
