package com.proc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proc.bean.Book;

/**ͼ��Dao*/
@Repository
public class BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**ͨ��ͼ���Ż�ȡͼ����Ϣ*/
    public Book get(String sn){
        
        String sql="SELECT * FROM book WHERE sn=?";
        RowMapper<Book> rowMapper=new BeanPropertyRowMapper<Book>(Book.class);
        Book book=jdbcTemplate.queryForObject(sql, rowMapper,sn);
        return book;
    }
}