package com.proc.service;

public interface BookShopService {

    /**
     * ����ͼ��
     * @param userId �����û�ID
     * @param sn ͼ����
     */
    void purchase(Integer userId,String sn);
}