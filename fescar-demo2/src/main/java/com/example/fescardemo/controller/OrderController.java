package com.example.fescardemo.controller;

import com.example.fescardemo.common.web.BaseResult;
import com.example.fescardemo.model.vo.OrderVO;
import com.example.fescardemo.service.OrderService;
import com.example.fescardemo.util.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/v1/api/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @GetMapping("/createOrder")
    public BaseResult<OrderVO> createOrder(@RequestParam(name = "goodsId") Long goodsId,
                                           @RequestParam(name = "goodsName") String goodsName,
                                           @RequestParam(name = "count") Integer count){
        //1.下单，减库存，减账户的钱
        OrderVO vo = new OrderVO();
        vo.setCount(count);
        vo.setGoodsId(goodsId);
        vo.setGoodsName(goodsName);
        orderService.createOrder(OrderUtils.voToModel(vo));
        return BaseResult.success(vo);
    }


}
