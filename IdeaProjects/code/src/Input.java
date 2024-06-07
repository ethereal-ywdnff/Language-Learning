import java.util.Scanner;

public class Input {
    public static void main(String [] args) {
        //receive user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your name: ");
        String name = scanner.next();
        System.out.println("enter your age: ");
        int age = scanner.nextInt();
        System.out.println("name: " + name + "\nage: " + age);
    }
}
