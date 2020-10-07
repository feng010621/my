package com.proc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proc.bean.Store;

/**ͼ��ֿ�Dao*/
@Repository
public class StoreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**ͨ��ͼ���Ż�ȡͼ������Ϣ*/
    public Store get(String sn){
        String sql="SELECT * FROM store WHERE sn=?";
        RowMapper<Store> rowMapper=new BeanPropertyRowMapper<Store>(Store.class);
        Store store=jdbcTemplate.queryForObject(sql, rowMapper,sn);
        return store;
    }
    
    /**ͨ��ͼ���ţ��޸�ͼ����  ���=��ǰ���-1*/
    public void update(String sn){
        String sql="UPDATE store SET stock=stock-1 WHERE sn=?";
        jdbcTemplate.update(sql, sn);
    }
}