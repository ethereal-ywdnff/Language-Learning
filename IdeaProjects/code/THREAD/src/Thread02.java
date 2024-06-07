public class Thread02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //dog.run();//wrong
        //创建了Thread对象，把dog对象（实现Runnable)，放入Thread
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {//通过实现Runnable接口，开发线程
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("yoyoyo " + ++count + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);//毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                break;
            }
        }
    }
}