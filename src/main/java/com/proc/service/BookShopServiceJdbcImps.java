package com.proc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proc.bean.Book;
import com.proc.bean.Store;
import com.proc.bean.User;
import com.proc.dao.BookDao;
import com.proc.dao.StoreDao;
import com.proc.dao.UserDao;
import com.proc.exception.BookStockException;
import com.proc.exception.UserBalanceException;

@Service("bookShopService")
public class BookShopServiceJdbcImps implements BookShopService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private BookDao bookDao;
    @Autowired
    private StoreDao storeDao;
    
    
    /**购买图书方法*/
    public void purchase(Integer userId, String sn) {
        
        //1:查收出图库存信息
        Store store= storeDao.get(sn);
        if(store.getStock()<=0){
            throw new BookStockException("图书库存不足："+store);
        }
        
        //2:查询图书信息
        Book book=bookDao.get(sn);
        
        
        //3:查询用户信息
        User user=userDao.get(userId);
        if(user.getBalance()<book.getPrice()){
            throw new UserBalanceException("用户余额不足："+user);
        }
        
        //4:修改库存
        storeDao.update(sn);
        
        //5:修改余额
        userDao.update(userId, book.getPrice());
    }

}