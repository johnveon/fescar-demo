package com.example.fescardemo.service.impl;

import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import com.example.fescardemo.repository.StockRepository;
import com.example.fescardemo.service.StockService;
import com.example.fescardemo.table.QStock;
import com.example.fescardemo.table.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    public Boolean reduceStock(Long goodsId, Integer count) {
        Optional<Stock> one = stockRepository.findOne(QStock.stock.goodsId.eq(goodsId));
        Stock stock = one.orElse(null);
        if (stock != null){
            stock.setCount(stock.getCount() - count);
            stockRepository.save(stock);
        }
        boolean b = true;
        if (b){
            throw new RuntimeException("人工错误");
        }
        return true;
    }
}
