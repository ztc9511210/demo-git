package com.example.demo.Bean;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by ztc on 2019/5/30 0030.
 */
//@Data简化java代码编写，为该类提供读写属性，还提供了equals(),hashCode(),toString()，get(), set()方法
@Data
//@Entity必须与@Id注解 结合使用 该名称用于引用查询中的实体 声明这是一个实体
@Entity
//@Table用来命名 当前实体类 对应的数据库 表的名字 声明这是一个要创建的表
@Table(name = "cat")
public class Cat {
    @Id
//    AUTO主键由程序控制自增, 是默认选项 ,不设置就是这个
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column定义了被标注字段在数据库表中所对应字段的名称
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

}
