package stringbuffer_;

public class StringAndStringbuffer {
    public static void main(String[] args) {
        String str = "abc";

        //String -> StringBuffer
        //方法1
        StringBuffer stringBuffer = new StringBuffer(str);
        //方法2
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(str);

        //StringBuffer -> String
        //方法1 使用StringBuffer提供的toString()方法
        StringBuffer stringBuffer3 = new StringBuffer("abc");
        //方法2 使用构造器来搞定
        String s = stringBuffer3.toString();
        String s1 = new String(stringBuffer3);
    }
}
