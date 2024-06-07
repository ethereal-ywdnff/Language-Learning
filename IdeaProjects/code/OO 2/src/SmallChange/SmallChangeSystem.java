package SmallChange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSystem {
    public static void main(String[] args) {
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String detail = "";
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("==========零钱通==========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退出");

            System.out.println("情选择(1-4): ");
            key = scanner.next();

            switch (key) {
                case "1" :
                    System.out.println("零钱通明细");
                    System.out.println(detail + "\n");
                    break;

                case "2" :
                    System.out.println("收益入账");
                    money = scanner.nextDouble();
                    balance += money;
                    date = new Date();
                    detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;

                case "3" :
                    System.out.println("3");
                    break;

                case "4" :
                    System.out.println("4");
                    loop = false;
                    break;
            }
        }while (loop);

        System.out.println("您退出了零钱通");
    }
}
