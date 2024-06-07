public class BitOperator {
    public static void main(String [] args) {
        //2 true form & inverse code & two' s complement: 00000000 00000010
        //3 true form & inverse code & two' s complement: 00000000 00000011
        //2&3: 00000000 00000010
        System.out.println(2&3);// 2
        //-2 true form : 10000000 00000010
        //   inverse code: 11111111 11111101
        //   two' s complement: 11111111 11111110
        //~-2 true form & two' s complement: 00000000 00000001
        System.out.println(~-2);// 1
        //2 true form & two' s complement: 00000000 00000010
        //~2 two' s complement: 11111111 11111101
        //   inverse code: 11111111 11111100
        //   true form: 1000000 0000011
        System.out.println(~2);// -3
        //2^3 true form & two' s complement: 00000000 00000001
        System.out.println(2^3);// 1
        System.out.println("");

        //right shift operator >>: the sign bit remains unchanged, overflow from the low bit,
        //                         where the overflow is filled with the sign bit
        // left shift operator <<: the sign bit remains unchanged, and the low bit is filled with 0

        //1 : 00000000 0000001 -> 0000000 00000000
        int a = 1 >> 2;
        System.out.println(a);//1 / 2 / 2 = 0
        //3 : 0000000 00000011 -> 0000000 00001100
        int b = 3 << 2;
        System.out.println(b);// 3 * 2 * 2 = 12
        int c = 10 >> 2;
        System.out.println(c);// 10 / 2 / 2 = 2
        //>>>: Low overflow, fill high with 0
        int d = 8 >>> 2;
        System.out.println(d);
    }
}
