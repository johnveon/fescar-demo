package com.example.fescardemo.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.example.fescardemo.common.web.BaseResult;
import com.example.fescardemo.repository.OrderRepository;
import com.example.fescardemo.service.OrderService;
import com.example.fescardemo.service.restful.StockConsumer;
import com.example.fescardemo.table.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private StockConsumer stockConsumer;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @GlobalTransactional(name = "createOrder")
    public Order createOrder(Order order) {
        orderRepository.save(order);
//        try {

            BaseResult<Boolean> result = stockConsumer.reduceStock(order.getGoodsId(), order.getCount());
            Boolean data = result.getData();
            if ( data != null && !data){
                throw new RuntimeException("减库存错误");
            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return order;
    }
}
