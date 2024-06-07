public class ArrayOfTwoDimensional {
    public static void main(String[] args) {
        // 1
        // 1 2
        // 1 2 3
        int[][] a = new int[3][];
        for (int i = 0; i < a.length; i++) {
            a[i] = new int[i + 1];
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = j + 1;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] b = {{4,6},{1,4,5,7},{-2}};
        int sum = 0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                sum  += b[i][j];
            }
        }
        System.out.println("sum: " + sum + "\n");

        //3 dimensional array
        int[][][] as = {{{1, 2, 3}, {4, 5, 6}}, {{7, 8, 9}, {10, 11, 12}}};
        System.out.println(as[1][1][1]);
        System.out.println(as[0][0].length);

        int[] x,y[];// x is 1 dimensional array and y is 2 dimensional array
        //x[0] = y false
        //y[0] = x true
        //y[0][0] = x false
        //x[0][0] = y false
        //y[0][0] = x[0] true
        //x = y false

    }
}
