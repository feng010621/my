package com.proc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proc.bean.User;

/**�û�Dao*/
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**ͨ���û�ID��ȡ�û���Ϣ*/
    public User get(Integer id){
        String sql="SELECT * FROM user WHERE id=?";
        RowMapper<User> rowMapper=new BeanPropertyRowMapper<User>(User.class);
        User user=jdbcTemplate.queryForObject(sql, rowMapper,id);
        return user;
    }
    
    /**�޸��û����*/
    public void update(Integer id,Double price){
        String sql="UPDATE user SET balance=balance-? WHERE id=?";
        jdbcTemplate.update(sql, new Object[]{price,id});
    }
}