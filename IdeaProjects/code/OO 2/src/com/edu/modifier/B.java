package com.edu.modifier;

public class B {
    public void samePackage() {
        A a = new A();
        //in the same package(public, protected, default)
        System.out.println("n1= " + a.n1 + " ,n2= " + a.n2 + ", n3= " + a.n3);
    }
}
