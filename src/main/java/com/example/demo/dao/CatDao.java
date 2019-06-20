package com.example.demo.dao;

import com.example.demo.Bean.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by ztc on 2019/6/3 0003.
 */
@Repository

public class CatDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 定义sql
     * 定义RowMapper
     * 执行查询方法
     * @return
     */
    public Cat selectById(Integer id){
        String sql = "select * from cat where id = ?";
        RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<>(Cat.class);
        Cat cat = jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper);
        return cat;
    }
}
