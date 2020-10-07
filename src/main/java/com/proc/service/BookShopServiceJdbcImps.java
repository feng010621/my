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
    
    
    /**����ͼ�鷽��*/
    public void purchase(Integer userId, String sn) {
        
        //1:���ճ�ͼ�����Ϣ
        Store store= storeDao.get(sn);
        if(store.getStock()<=0){
            throw new BookStockException("ͼ���治�㣺"+store);
        }
        
        //2:��ѯͼ����Ϣ
        Book book=bookDao.get(sn);
        
        
        //3:��ѯ�û���Ϣ
        User user=userDao.get(userId);
        if(user.getBalance()<book.getPrice()){
            throw new UserBalanceException("�û����㣺"+user);
        }
        
        //4:�޸Ŀ��
        storeDao.update(sn);
        
        //5:�޸����
        userDao.update(userId, book.getPrice());
    }

}