public class Thread01 {
    public static void main(String[] args) {
        //创建Cat对象，可以当作线程使用
        Cat cat = new Cat();
        cat.start();
    }
}

//1.当一个类继承了Thread类，该类就可以当做线程使用
//2.我们会重写ru方法，写上自己的业务代码
//3.run Thread类实现了 Runnable 接口的run方法
class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("wowowo " +(++times));
            try {
                Thread.sleep(1000);//毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 5) {
                break;
            }
        }
    }
}