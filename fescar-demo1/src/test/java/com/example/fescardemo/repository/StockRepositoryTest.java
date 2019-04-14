package com.example.fescardemo.repository;

import com.example.fescardemo.table.Stock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockRepositoryTest {


    @Autowired
    private StockRepository stockRepository;

    @Test
    public void save(){
        Stock stock = new Stock();
        stock.setCount(100);
        stock.setGoodsId(10001L);
        Stock save = stockRepository.save(stock);

        Assert.assertThat(save, notNullValue());

    }


}