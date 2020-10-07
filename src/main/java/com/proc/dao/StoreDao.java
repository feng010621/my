package com.proc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proc.bean.Store;

/**图书仓库Dao*/
@Repository
public class StoreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**通过图书编号获取图书库存信息*/
    public Store get(String sn){
        String sql="SELECT * FROM store WHERE sn=?";
        RowMapper<Store> rowMapper=new BeanPropertyRowMapper<Store>(Store.class);
        Store store=jdbcTemplate.queryForObject(sql, rowMapper,sn);
        return store;
    }
    
    /**通过图书编号，修改图书库存  库存=当前库存-1*/
    public void update(String sn){
        String sql="UPDATE store SET stock=stock-1 WHERE sn=?";
        jdbcTemplate.update(sql, sn);
    }
}