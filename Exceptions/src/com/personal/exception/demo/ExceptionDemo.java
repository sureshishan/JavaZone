package com.personal.exception.demo;

import java.lang.*;

public class ExceptionDemo{
    public static void main(String args[]){
        A a1 = new A();
        B b1 = (B)a1;
    }
}
class A{

}
class B extends A{

}