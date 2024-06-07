package list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("damon");
        list.add("stephan");

        //在index=1 的位置插入一个对象
        list.add(1,"elena");
        List list2 = new ArrayList();
        list2.add("abc");
        list2.add("abc");
        list.addAll(3,list2);

        //返回该对象在集合中首次出现的位置
        list.indexOf("elena");
        //返回该对象在集合中最后一次出现的位置
        list.indexOf("abc");

        //设置index位置的元素，相当于替换
        list.set(3,"lll");

        //List subList(int fromIndex, int toIndex): 返回从fromIndex到toIndex位置的子集合
        //注意: 返回的子集合 fromIndex <= subList < toIndex
        List returnList = list.subList(0,5);//返回 0～4
        System.out.println("return list: " + returnList);
    }
}
