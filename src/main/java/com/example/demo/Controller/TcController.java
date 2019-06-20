package com.example.demo.Controller;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * Created by ztc on 2019/6/12 0012.
 */
public class TcController {

    /**
     * 反射 调用父类当中构造函数
     * @throws Exception
     */
    @Test
    public void Tc() throws Exception {
        Class clazz = Class.forName("com.example.demo.Bean.Son");
        System.out.println(getFieldValue(clazz.newInstance(), "privateField"));
    }

    public static Field getDeclaredField(Object object, String FieldName) {
        Field field = null;
        Class clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(FieldName);
                field.setAccessible(true);
                return field;
            } catch (Exception ex) {

            }
        }
        return null;
    }

    private static Object getFieldValue(Object object, String FieldName) throws Exception {
        Field field = getDeclaredField(object,FieldName);
        return field.get(object);
    }
}