package com.edu.modifier1;

import com.edu.modifier.A;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        //under different packages, only public can be used
        System.out.println("n1= " + a.n1);
    }

}