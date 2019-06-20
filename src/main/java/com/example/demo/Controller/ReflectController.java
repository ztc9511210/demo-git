package com.example.demo.Controller;

import com.example.demo.Bean.Cat;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by ztc on 2019/6/14 0014.
 */
public class ReflectController {

    public static void main() throws ClassNotFoundException {
        Cat cat = new Cat();
        Class clazz = Class.forName("com.example.demo.Bean.Cat");
        Field[] files = clazz.getDeclaredFields();
        for (Field field : files){
            System.out.println(field.getName());
        }
    }
}
