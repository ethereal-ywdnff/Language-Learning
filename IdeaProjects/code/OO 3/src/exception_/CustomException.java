package exception_;

public class CustomException {
    public static void main(String[] args) {
        int age = 80;

        if (!(age >= 18 && age<=  120)) {
            throw new AgeException("your age should be between 18 and 120");
        }
        System.out.println("your age is proper");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}