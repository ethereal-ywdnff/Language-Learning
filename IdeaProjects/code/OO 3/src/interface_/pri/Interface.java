package interface_.pri;

public class Interface {
    public static void main(String[] args) {
        Camera camera = new Camera();
        Phone phone = new Phone();

        Computer computer = new Computer();
        computer.work(camera);
        System.out.println("==============================");
        computer.work(phone);
    }
}
