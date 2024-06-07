package Polymorphic.PolyDetail;

public class PolyDetail02 {
    public static void main(String[] args) {
        //instanceof 判断运行类型是否为XX的子类型
        BB bb = new BB();
        System.out.println(bb instanceof BB);
        System.out.println(bb instanceof AA);
        System.out.println("-------------------");

        AA aa = new BB();
        System.out.println(aa instanceof BB);
        System.out.println("-------------------");

        Object obj = new Object();
        Object obj1 = null;
        System.out.println(obj instanceof AA);
        System.out.println(obj1 instanceof AA);
        System.out.println("-------------------");

        String str = "str";
        System.out.println(str instanceof Object);
    }
}

class AA {

}

class BB extends AA{

}