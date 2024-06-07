import java.util.Scanner;

public class SequenceSearch {
    public static void main(String[] args) {
        String[] names = {"白眉鹰王", "金毛狮王", "紫衫龙王", "青翼蝠王"};
        Scanner scanner = new Scanner(System.in);

        System.out.println("please enter the name");
        String name = scanner.next();

        int index = -1;
        for (int i = 0; i < names.length; i++) {
            if (name.equals(names[i])) {
                System.out.println("you find " + name);
                index = 1;
                break;
            }
        }
        if (index == -1) {
            System.out.println("we didn't find " + name);
        }
    }
}
