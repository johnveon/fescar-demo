package com.example.fescardemo.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.example.fescardemo.common.web.BaseResult;
import com.example.fescardemo.repository.OrderRepository;
import com.example.fescardemo.service.OrderService;
import com.example.fescardemo.service.restful.AccountConsumer;
import com.example.fescardemo.service.restful.StockConsumer;
import com.example.fescardemo.table.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private StockConsumer stockConsumer;

    @Autowired
    private AccountConsumer accountConsumer;

    @Override
    @GlobalTransactional(name = "createOrder")
    public Order createOrder(Order order) {
        //1.保存成功
        orderRepository.save(order);
        //2.保存成功
        stockConsumer.reduceStock(order.getGoodsId(), order.getCount());
        //3.保存失败，导致前面的两个成功的回滚
        accountConsumer.reduceAccount(32L, 100L);
        return order;
    }
}
