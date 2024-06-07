public class IDDetail {
    public static void main(String [] args) {
        byte n1 = 1;// 1 byte, 8 digits 00000001
        short n2 = 2;// 2 bytes, 16 digits 00000000 00000010
        int n3 = 3;// 4 bytes
        long n4 = 4L; //8 bytes

        float n5 = 5.1F;// 4 bytes
        double n6 = 6.1;// 8bytes
        double nd = 7d;

        System.out.println(5.12e2);// 5.12 x 10^2 = 512.0
        System.out.println(5.12E-2);// 0.0512
        System.out.println("");

        double n7 = 8.1 / 3;
        System.out.println(n7);// not 2.7
        double n8 = 2.7;
        //
        if (Math.abs(n7 - n8) < 0.001) {
            System.out.println("The difference is very small, which is equivalent to equal");
        } else {
            System.out.println("not equal");
        }


        char c1;// 2 bytes
        System.out.println("");
        System.out.println((int)'刘');
        System.out.println('a' + 10);// 107
        char c2 = 'b' + 2;
        System.out.println((int)c2);// 100
        System.out.println(c2);// d


        boolean b;// 1 byte

        System.out.println("");
        int i = 1;
        String s = i + "";
        String str = c2 + "";
        System.out.println(str);
    }
}
