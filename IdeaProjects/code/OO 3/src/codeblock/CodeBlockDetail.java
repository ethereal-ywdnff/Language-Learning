package codeblock;

public class CodeBlockDetail {
    public static void main(String[] args) {
        //AA aa = new AA();
        //使用静态成员前也会先执行代码块
        //普通代码块只有在创建对象时会被调用，使用静态成员时不会被调用
        System.out.println(Cat.n);

    }
}

class Animal {
    static {
        System.out.println("animal");
    }
}

class Cat extends Animal{
    public static int n = 10;
    {
        System.out.println("Cat");
    }
}

class BB {
    static {
        System.out.println("BB");
    }
}

class AA extends BB {
    static {
        System.out.println("AA");
    }
}
