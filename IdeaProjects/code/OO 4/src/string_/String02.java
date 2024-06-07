package string_;

public class String02 {
    public static void main(String[] args) {
        String name = "lkh";
        int age = 18;
        double score = 100;
        char gender = 'm';

        //%s 字符串,  %d 整数,  %.2f 保留小数点后两位,  %c char
        String formatStr = "my name is %s, age is %d, score is %.2f, gender is %c";
        String info = String.format(formatStr,name,age,score,gender);
        System.out.println(info);
    }
}
