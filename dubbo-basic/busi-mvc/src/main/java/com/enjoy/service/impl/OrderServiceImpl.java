package com.enjoy.service.impl;

import com.enjoy.dao.OrderDao;
import com.enjoy.entity.OrderEntiry;
import com.enjoy.service.OrderService;
import com.enjoy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductService productService;


    @Override
    public OrderEntiry getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
        OrderEntiry orderEntiry =  orderDao.getDetail(id);
        orderEntiry.addProduct(productService.getDetail("P001"));
        orderEntiry.addProduct(productService.getDetail("P002"));

        return orderEntiry;
    }
}
