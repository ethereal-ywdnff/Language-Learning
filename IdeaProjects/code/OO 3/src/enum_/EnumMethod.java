package enum_;

public class EnumMethod {
    public static void main(String[] args) {
        Season3 season3 = Season3.SPRING;
        //name() 输出枚举对象的名字
        System.out.println(season3.name());
        //ordinal() 输出枚举对象的编号(从0开始编号)
        System.out.println(season3.ordinal());
        //values() 含有定义的所有枚举对象
        Season3[] values = Season3.values();
        for (Season3 value : values) {
            System.out.println(value);
        }
        //valueOf() 将字符串转换为枚举对象，要求字符串必须为已有的常量名，否则会报异常
        Season3 spring = Season3.valueOf("SPRING");
        System.out.println(season3 == spring);
        //compareTo() 前一个编号减后一个的编号 2-1=1
        System.out.println(Season3.AUTUMN.compareTo(Season3.SUMMER));//1
    }
}

enum Season3 {

//    public static Season SPRING = new Season("spring","warm");
//    public static Season SUMMER = new Season("summer","hot");
//    public static Season AUTUMN = new Season("autumn","cool");
//    public static Season WINTER = new Season("winter","cold");

    //如果有多个常量，用逗号隔开就行了
    //使用enum时，要将常量对象写在前面(SPRING...)
    //必须写在类的最前面
    //如果使用的是无参构造器则可以只写()或省略()
    SPRING("spring", "warm"), SUMMER("summer", "hot"),
    AUTUMN("autumn","cool"),WINTER("winter","cold");

    private String name;
    private String des;

    private Season3(String name, String des) {
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