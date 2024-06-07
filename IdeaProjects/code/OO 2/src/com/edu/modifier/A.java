package com.edu.modifier;

//only public and default can modify the class
public class A {
    public int n1 = 100;//this class, same package, successor, other packages
    protected int n2 = 100;//this class, same package, successor
    int n3 = 100;//this class, same package
    private int n4 = 100;//this class

    //in the same class(public, protected, default, private)
    public void sameClass() {
        System.out.println("n1= " + n1 + ", n2= " + n2 + ", n3= " + n3 + ", n4= " + n4);
    }
}
