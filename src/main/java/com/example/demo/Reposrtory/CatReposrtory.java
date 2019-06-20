package com.example.demo.Reposrtory;


import com.example.demo.Bean.Cat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ztc on 2019/5/31 0031.
 */

/**
 * CrudRepository <表明，id类型> 提供了最基本的对实体类的增删改查操作，
 */
public interface CatReposrtory extends CrudRepository<Cat, Integer> {

//    ?1代表第一参数 ?2代表第二个参数 以此类推 原生查询
    @Query(value = "select c.* from cat c WHERE c.name like CONCAT('%',?1,'%') AND c.age like CONCAT('%',?2,'%')",nativeQuery = true)
    List<Cat> selectNameAndAGE(String name,Integer ages);

    @Modifying
    @Query(value = "UPDATE cat set age = ?1 WHERE id = ?2 ",nativeQuery = true)
    public void update(Integer age,int id);

    @Query(value = "select *from cat where id = ?1",nativeQuery = true)
    public Cat selectByName(String name);
}
