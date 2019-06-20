package com.example.demo.Controller;

import com.example.demo.Bean.Cat;
import com.example.demo.Bean.Person;
import com.example.demo.Service.CatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

/**
 * Created by ztc on 2019/6/1 0001.
 */
@RestController
@RequestMapping(value = "Cat")
public class CatController {
    @Resource
    private CatService catService;

    /**
     * 添加数据
     */
    @PostMapping(value = "save")
    public Cat save(Cat cat,HttpServletRequest request){
        try {
            request.getParameter(String.valueOf(cat));
            catService.save(cat);
            return cat;
        }catch (Exception ex){
            ex.printStackTrace();
            return cat;
        }
    }

    /**
     * 删除数据
     */
    @PostMapping(value = "/delete")
    public String delete(int id){
        try {
            catService.delete(id);
            return "delete OK";
        }catch (Exception ex){
            return "error";
        }
    }

    /**
     * 多条件模糊查询
     * @return
     */
    @GetMapping(value = "getAll")
    public List<Cat> getAll(String name,Integer age) {
        return catService.findByNameAndAge(name,age);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping(value = "findById")
    public Optional<Cat> findById(int id){
        return catService.findById(id);
    }

    /**
     * 更新
     * @param age
     * @param id
     */
    @GetMapping(value = "update")
    public void update(@RequestParam("age")Integer age,@RequestParam("id") int id){
        Cat cat = new Cat();
        cat.setAge(age);
        cat.setId(id);
        catService.update(age,id);
    }

    /**
     * 更新（如果数据库有不更新的字段会把数据库的字段值更新成null）不提议用
     * @param cat
     */
    @GetMapping(value = "update1")
    public void  update1(Cat cat){
        catService.save(cat);
    }

    /**
     * 查詢
     * @param id
     * @return
     */
    @RequestMapping(value = "selectById")
    public Cat selectById(Integer id,HttpServletRequest request){
        return catService.selectById(id);

    }

    /**
     * Java反射
     * @param args
     */
    public static void main(String[] args) throws ClassNotFoundException {
////        实例化对象
//        Person person = new Person();
////        通过对象调用 getClass() 方法来获取,通常应用在：比如你传过来一个 Object类型的对象，而我不知道你具体是什么类，用这种方法
//        Class clazz = person.getClass();
//        String className = clazz.getName();
//        System.out.println(className);
//        System.out.println("-----------------通过对象调用 getClass() 方法来获取");
////        获得类的public类型的属性。
//        Field[] fields = clazz.getFields();
//        for (Field field : fields){
//            System.out.println(field.getName());
//        }
//        System.out.println("-----------------获得类的public类型的属性");
////        获得类的所有属性。包括私有的
//        Field[] allFields = clazz.getDeclaredFields();
//        for (Field field : allFields){
//            System.out.println(field.getName());
//        }
//        System.out.println("-----------------获得类的所有属性。包括私有的");
//////        获得类的public类型的方法。这里包括 Object 类的一些方法
//        Method[] methods = clazz.getMethods();
//        for (Method method : methods){
//            System.out.println(method.getName());
//        }
//        System.out.println("-----------------获得类的public类型的方法。这里包括 Object 类的一些方法");
////        获得类的所有的方法
//        Method[] allMethod = clazz.getDeclaredMethods();
//        for (Method method : allMethod){
//            System.out.println(method.getName());
//        }
//        System.out.println("-----------------获得类的所有的方法");
//
//        Constructor[] constructors = clazz.getConstructors();
//        for (Constructor constructor : constructors){
//            System.out.println(constructor.toString());
//        }
//        System.out.println("-----------------获取构造方法");



//        1.实例化对象
        Cat cat = new Cat();
//        2.加载Class对象
        Class clazz = Class.forName("com.example.demo.Bean.Cat");
//       3. 取出类对象中的所有属性
        Field[] allFields =clazz.getDeclaredFields();
        for (Field field :allFields){
            System.out.println(field.getName());
        }


//        Constructor[] constructors = clazz.getConstructors();
//        for (Constructor constructor : constructors){
//            System.out.println(constructor.toString());
//            System.out.println(constructor.getName());
//            System.out.println(constructor.hashCode());
//        }
    }
}
