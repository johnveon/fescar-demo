package com.example.fescardemo.model.vo;

import lombok.Data;

@Data
public class OrderVO {

    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private Integer count;
}
