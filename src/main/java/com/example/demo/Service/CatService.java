package com.example.demo.Service;

import com.example.demo.Bean.Cat;
import com.example.demo.Reposrtory.CatReposrtory;
import com.example.demo.dao.CatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Created by ztc on 2019/5/31 0031.
 */
@Service
public class CatService {

    @Autowired
    private CatReposrtory catReposrtory;

    @Autowired
    private CatDao catDao;

    /**
     * 保存数据
     */
    @Transactional
    public Cat save(Cat cat){
//        Cat checkName = catReposrtory.selectByName(cat.getName());
       return catReposrtory.save(cat);
    }

    /**
     * 删除
     */
    @Transactional
    public void delete(int id){
        catReposrtory.deleteById(id);
    }

    /**
     * 多条件查询
     */
    @Transactional
    public List<Cat> findByNameAndAge(String name,Integer age){
        if (StringUtils.isEmpty(name)){
            String names = "";
            name = names;
        }

        return catReposrtory.selectNameAndAGE(name,age);
    }


    /**
     * 查询
     * @param id
     * @return
     */
    @Transactional
    public Optional<Cat> findById(int id){
        return catReposrtory.findById(id);
    }

    /**
     * 更新
     * @param age
     * @param id
     * @return
     */
    @Transactional
    public String update(@RequestParam("age")Integer age,@RequestParam("id") int id){
        catReposrtory.update(age,id);
        return "ok";
    }

    /**
     * 查詢
     * @param id
     * @return
     */
    public Cat selectById(Integer id){
        return catDao.selectById(id);
    }

//    public String selectByName(String name){
//        return catReposrtory.selectByName(name);
//    }
}
