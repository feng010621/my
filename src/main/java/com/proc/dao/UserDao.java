package com.proc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proc.bean.User;

/**用户Dao*/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**通过用户ID获取用户信息*/
    public User get(Integer id){
        String sql="SELECT * FROM user WHERE id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        User user=jdbcTemplate.queryForObject(sql, rowMapper,id);
        return user;
    }
    
    /**修改用户余额*/
    public void update(Integer id,Double price){
        String sql="UPDATE user SET balance=balance-? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{price,id});
    }
}