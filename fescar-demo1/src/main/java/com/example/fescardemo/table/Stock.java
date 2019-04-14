package com.example.fescardemo.table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "t_stock_stock")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long stockId;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "count")
    private Integer count;
}
