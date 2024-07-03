package com.powernode.spring6.bean;

import java.util.Date;

/**
 * @author 动力节点
 * @version 1.0
 * @className People
 * @since 1.0
 **/
public class People {
    private String name;
    private int age;
    private boolean sex;
    private Date birth;

    // c命名空间是简化构造注入的。
    // c命名空间注入办法是基于构造方法的。


    public People(String name, int age, boolean sex, Date birth) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birth=" + birth +
                '}';
    }
}
