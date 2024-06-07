public class ContinueAndReturn {
    public static void main(String[] args) {
        /*label1:
        for (int i = 0; i < 2; i++) {
            label2:
            for (int j = 0; j < 4; j++) {
                if (j == 2) {
                    continue;
                    //continue label1;
                }
                System.out.println("j= " + j);
            }
        }
        System.out.println();*/

        /*for (int i = 0; i < 5; i++) {
            if (i == 3) {
                System.out.print(i);
                //break;//yyy3k
                //continue;//yyy3yk
                return;//yyy3
            }
            System.out.print("y");
        }
        System.out.print("k");*/

        for (char c = 'a'; c < 'z'; c++) {
            //change char to string and print the upper case
            //System.out.print(String.valueOf(c).toUpperCase() + " ");
            System.out.print(Character.toString(c) + " ");
        }
        System.out.println();

        double sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum -= 1.0 / i;
            } else {
                sum += 1.0 / i;
            }
        }
        System.out.println("sum : " + sum);

        int o = 5;
        int s = 0;
        for (int i = 1; i <= o; i++) {
            for (int j = 1; j <= i; j++) {
                s += j;
                if (j == 1 && i == 1) {
                    System.out.print("1+");
                }
                if (j == 1 && i > 1) {
                    System.out.print("(1");
                }
                if (j > 1 && j <= i) {
                    System.out.print("+" + j);
                }
                if (j == i && j != 1 && i != o) {
                    System.out.print(")+");
                }
                if (j == i && j != 1 && i == o) {
                    System.out.println(")");
                }
            }
        }
        System.out.print("=" + s);
    }
}
