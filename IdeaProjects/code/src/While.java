public class While {
    public static void main(String[] args) {
        int a = 1;
        do {
            System.out.println("it's " + a);
            a++;
        } while(a<=10);
        System.out.println(a);

        //sum of 1-10
        int c = 1, d = 10;
        int sum = 0;
        do {
            sum += c;
            c ++;
        } while(c <= d);
        System.out.println(sum);
    }
}
