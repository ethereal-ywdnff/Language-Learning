package homework;

public class Homework {
    /**
     * 输入用户名、密码、邮箱，如果信息录入正确，则提示注册成功，否则生成异常对象 要求：
     * (1) 用户名长度2,3或4
     * (2) 密码的长度为6，要求全是数字(isDigital)
     * (3) 邮箱中包@和.  并且@在.的前面
     * @param args
     */
    public static void main(String[] args) {
        String name = "tom";
        String pwd = "123456";
        String email = "12345@123.com";

        try {
            userRegister(name, pwd, email);
            System.out.println("you registered successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        int userLength = name.length();
        if (!(userLength >= 2 && userLength <= 4)) {
            throw new RuntimeException("the user name length should be 2 or 3 or 4");
        }

        if (!(pwd.length() == 6 && isDigit(pwd))) {
            throw new RuntimeException("password length is 6 and requires all numbers");
        }

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > 1)) {
            throw new RuntimeException("emial should contain \"@\" and \".\", where \"@\" is in front of \".\"");
        }
    }

    public static boolean isDigit(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
