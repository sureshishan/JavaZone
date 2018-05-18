Is ClassCastException recognized by the compiler?

    No.

Example:

package com.personal.exception.demo;

public class ExceptionDemo{
    public static void main(String args[]){
        A a1 = new A();
        B b1 = (B)a1;  // It leads to ClassCastException but arised at Runtime.
    }
}
class A{

}
class B extends A{

}

OutPut:

Exception in thread "main" java.lang.ClassCastException: com.personal.exception.demo.A cannot be cast to com.personal.exception.demo.B
        at com.personal.exception.demo.ExceptionDemo.main(ExceptionDemo.java:6)

Any Exception is Java is a Class.

All the Exeption classes are Concrete Classes not even single Exception class is Abstract.

How the Exception is being raised by the Runtime environment.

For every abnormal situation there is Exception class in the library.

When runtime recognize the abnormal situation it will create the object of the abnormal situation (Exception)