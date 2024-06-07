package exception_;

public class TryCatch {
    public static void main(String[] args) {

        //1,如果ty代码块有可能有多个异常，可以使用多个catch分别捕获不同的异常，相应处理
        //2.要求子类异常写在前面，父类异常写在后面
        try {
            Person person = new Person();
            //person = null;
            System.out.println(person.getName());
            int n1 = 10;
            int n2 = 0;
            int res = n1/n2;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (java.lang.Exception e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {//始终会执行
            System.out.println("the program is over");
        }

    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }
}