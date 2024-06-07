package homework;

public class Homework01 {
    public static void main(String[] args) {
        String name = "Kang hua Liu";
        printName(name);
    }
    /**
     * 编写java程序，输入形式为：Han shun Ping的人名，以Ping,Han .S的形式打印出来
     * 其中.S是中间单词的首字母
     */
    public static void printName(String str) {
        if (str == null) {
            System.out.println("cannot be empty");
            return;
        }

        String [] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("your type format is incorrect");
            return;
        }

        String format = String.format("%s,%s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
