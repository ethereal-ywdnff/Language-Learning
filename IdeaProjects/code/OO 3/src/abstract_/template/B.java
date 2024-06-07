package abstract_.template;

public class B extends Template{
    public void job() {
        long num = 0;
        for (long i = 0; i < 800000; i++) {
            num *= i;
        }
    }
}
