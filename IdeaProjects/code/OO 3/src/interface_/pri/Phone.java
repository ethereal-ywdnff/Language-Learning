package interface_.pri;

public class Phone implements Usb{
    @Override
    public void start() {
        System.out.println("phone starts working....");
    }

    @Override
    public void stop() {
        System.out.println("phone stops working....");
    }
}
