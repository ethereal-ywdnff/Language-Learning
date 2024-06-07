public class Switch {
    public static void main(String[] args) {
        char a = 'a';
        switch ('a') {
            //case shouldn't be variable(a)
            case 'a', 'v':
                System.out.println("it's a.");
                break;
            case 'b':
                System.out.println("it's not a.");
                break;
            default:
                System.out.println("it's done.");
        }

        switch (a) {
            case 'a' -> System.out.println("good");
            case 'b' -> System.out.println("great.");
            default -> System.out.println("jesus");
        }
    }
}
