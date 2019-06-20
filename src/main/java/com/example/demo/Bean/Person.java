package com.example.demo.Bean;

/**
 * Created by ztc on 2019/6/12 0012.
 */
public class Person {
    private String name = "小红";

    public int age = 10;

//    构造方法
    public Person(){

    }

    private void sa(){
        System.out.println("private sa()...");
    }

    public void root(){
        System.out.println("public root()...");
    }

}
