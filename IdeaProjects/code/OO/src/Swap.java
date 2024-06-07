public class Swap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        //swap(a, b);
        //System.out.println("main:\t" + a + "\t" + b);

        int[] arr = {1, 2, 3};
        array(arr);
        System.out.println("main: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        Person1 p = new Person1();
        test(p);
        System.out.println(p.age);
    }

    public static void swap(int a, int b) {
        System.out.println("before:\t" + a + "\t" + b);
        int temp = a;
        a = b;
        b = temp;
        System.out.println("after:\t" + a + "\t" + b);
    }

    public static void array(int[] arr) {

        arr[0] = 10;
        System.out.println("in the array(): ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void test(Person1 p) {
        //p.age = 100;
        //p = null;
        p = new Person1();
        p.name = "Tom";
        p.age = 23;
    }
}

class Person1 {
    String name;
    int age = 10;
}