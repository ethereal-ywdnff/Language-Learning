package interface_.pri;

public class Camera implements Usb{
    @Override
    public void start() {
        System.out.println("camera starts working....");
    }

    @Override
    public void stop() {
        System.out.println("camera stops working....");
    }
}
