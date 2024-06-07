package list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //List集合类中元素有序（即添加顺序和取出顺序一致）、且可重复
        List list = new ArrayList();
        list.add("lkh");
        list.add(10);
        list.add("tom");
        list.add("lkh");
        System.out.println("list: " + list);

        //List集合中的每个元素都有其对应的顺序索引，即支持索引
        //索引是从0开始的
        System.out.println(list.get(3));//lkh
    }
}
