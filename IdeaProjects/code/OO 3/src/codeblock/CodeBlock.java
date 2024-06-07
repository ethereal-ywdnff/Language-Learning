package codeblock;

public class CodeBlock {
    public static void main(String[] args) {
        Movie movie = new Movie("coco");
        System.out.println();
        Movie movie2 = new Movie("coco", 10000000);
    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    //不管调用哪个构造器，创造对象，都会先调用代码块的内容
    //代码块调用的顺序优先于构造器
    //static只会执行一次
    static {
        System.out.println("movie begins");
    }

    {
        System.out.println("movie begins");
        System.out.println("end of movie");
    }

    public Movie(String name) {
        System.out.println("Movie(String name) is called");
        this.name = name;
    }

    public Movie(String name, double price) {
        System.out.println("Movie(String name, double price) is called");
        this.name = name;
        this.price = price;
    }

    public Movie(String name, double price, String director) {
        System.out.println("Movie(String name, double price, String director) is called");
        this.name = name;
        this.price = price;
        this.director = director;
    }
}
