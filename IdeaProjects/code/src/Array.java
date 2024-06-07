public class Array {
    public static void main(String[] args) {
        //a and b use the same array
        int[] a = {10, 33, 29};
        int[] b = a;
        b[0] = 20;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        //Copy the contents of array c to array d
        int[] c = {23, 45, 98};
        int[] d = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            d[i] = c[i];
        }

        //reverse the array(method 1)
        int[] e = {23, 45, 98, 100, 32};
        for (int i = 0; i < e.length / 2; i++) {
            int temp = e[e.length - 1 - i];
            e[e.length - 1 - i] = e[i];
            e[i] = temp;
        }
        for (int i = 0; i < e.length; i++) {
            System.out.print(e[i] + " ");
        }
        System.out.println();
        //reverse the array(method 2)
        int[] f = new int[e.length];
        for (int i = e.length - 1, j = 0; i >= 0; i--, j++) {
            f[j] = e[i];
        }
        for (int i = 0; i < e.length; i++) {
            System.out.print(f[i] + " ");
        }
    }
}
