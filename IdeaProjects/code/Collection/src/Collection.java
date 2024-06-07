import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("tom");//添加单个元素
        list.add(10);
        list.add(true);

        list.remove(0);//删除第一个元素
        list.remove("tom");//指定删除某个对象

        //contains: 查找某个元素是否存在
        System.out.println(list.contains("10"));

        list.size();//查看元素个数
        list.isEmpty();//判断是否为空
        list.clear();//清空所有元素
        ArrayList al = new ArrayList();
        al.add(10);
        al.add("tim");
        list.addAll(al);//添加多个元素
        list.containsAll(al);//查找多个元素是否存在
        list.removeAll(al);//删除多个元素
    }
}
