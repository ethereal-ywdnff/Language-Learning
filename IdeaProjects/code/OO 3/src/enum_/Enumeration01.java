package enum_;

public class Enumeration01 {
    public static void main(String[] args) {
        System.out.println(Season2.SPRING);
    }
}

//enum不能继承别的类，只能实施别的接口
enum Season2 {

//    public static Season SPRING = new Season("spring","warm");
//    public static Season SUMMER = new Season("summer","hot");
//    public static Season AUTUMN = new Season("autumn","cool");
//    public static Season WINTER = new Season("winter","cold");

    //如果有多个常量，用逗号隔开就行了
    //使用enum时，要将常量对象写在前面(SPRING...)
    //必须写在类的最前面
    //如果使用的是无参构造器则可以只写()或省略()
    SPRING("spring", "warm"), SUMMER("summer", "hot"),
    AUTUMN(),WINTER;

    private String name;
    private String des;

    Season2() {}
    private Season2(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}

