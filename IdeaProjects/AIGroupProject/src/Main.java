public class Main {
    public static void main(String[] args) {
        boolean result = MyDialog.showDialog();
        if (result) {
            System.out.println("User chose the correct option.");
        } else {
            System.out.println("User did not choose the correct option.");
        }
    }
}
