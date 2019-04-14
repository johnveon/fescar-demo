package com.example.fescardemo.util;

import com.example.fescardemo.model.vo.OrderVO;
import com.example.fescardemo.table.Order;

public class OrderUtils {

    public static Order voToModel(OrderVO vo) {
        Order model = new Order();
        model.setOrderId(vo.getOrderId());
        model.setGoodsName(vo.getGoodsName());
        model.setGoodsId(vo.getGoodsId());
        model.setCount(vo.getCount());
        return model;
    }
}
