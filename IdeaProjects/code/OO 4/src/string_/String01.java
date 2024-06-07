package string_;

public class String01 {
    public static void main(String[] args) {
        //String是final类，不能被其他的类继承
        //String有属性private final char value[]；用于存放字符串内容
        //一定要注意：value是一个final类型，不可以修改：即value不能指向 新的地址，但是单个字符内容是可以变化
        String name = "tom";
        name = "tim";
        final char[] value = {'a','b','c'};
        char[] v2 = {'x','y','z'};
        value[0] = 'i';
        //value = v2;//不可修改value地址，除非把value的final去掉
    }
}
