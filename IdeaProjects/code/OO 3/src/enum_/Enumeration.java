package enum_;

public class Enumeration {
    public static void main(String[] args) {
        System.out.println(Season.AUTUMN);
    }
}

class Season {
    private String name;
    private String des;

    public static Season SPRING = new Season("spring","warm");
    public static Season SUMMER = new Season("summer","hot");
    public static Season AUTUMN = new Season("autumn","cool");
    public static Season WINTER = new Season("winter","cold");

    private Season(String name, String des) {
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