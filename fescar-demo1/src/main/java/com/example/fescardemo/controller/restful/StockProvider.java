package com.example.fescardemo.controller.restful;


import com.example.fescardemo.common.web.BaseResult;
import com.example.fescardemo.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock/v1/api/stock")
public class StockProvider {


    @Autowired
    private StockService stockService;

    @GetMapping("/reduceStock")
    public  BaseResult<Boolean> reduceStock(@RequestParam(name = "goodsId") Long goodsId,
                                    @RequestParam(name = "count") Integer count){
        stockService.reduceStock(goodsId, count);

        return BaseResult.success(true);
    }

}
