package interface_.pri;

public class Computer {
    public void work(Usb usb) {
        usb.start();
        usb.stop();
    }
}
