package com.example.fescardemo.service.restful;

import com.example.fescardemo.common.web.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${restful.stock.name:}", url = "${restful.stock.url:}")
public interface StockConsumer {

    //出现400 reading错误 可能：1.没写@RequestParam(name = "goodsId")；2.goodsId 为空
    @GetMapping("/stock/v1/api/stock/reduceStock")
    BaseResult<Boolean> reduceStock(@RequestParam(name = "goodsId") Long goodsId,
                                    @RequestParam(name = "count") Integer count);
}
