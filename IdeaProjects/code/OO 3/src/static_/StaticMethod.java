package static_;

public class StaticMethod {
    public static void main(String[] args) {
        Student tom = new Student("tom");
        tom.payFee(100);
        Student tim = new Student("tim");
        tim.payFee(150);

        Student.showFee();
    }
}

class Student {
    private String name;
    private static double fee = 0;

    public Student(String name) {
        this.name = name;
    }

    //当方法使用了static后，该方法就是静态方法
    //静态方法可以访问静态属性
    public static void payFee(double fee) {
        Student.fee += fee;
    }

    public static void showFee() {
        System.out.println("the total fee is " + Student.fee);
    }
}
