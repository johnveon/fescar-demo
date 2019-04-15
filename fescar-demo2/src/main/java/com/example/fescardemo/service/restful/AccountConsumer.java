package com.example.fescardemo.service.restful;

import com.example.fescardemo.common.web.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${restful.account.name:}", url = "${restful.account.url:}")
public interface AccountConsumer {

    //出现400 reading错误 可能：1.没写@RequestParam(name = "goodsId")；2.goodsId 为空
    @GetMapping("/account/v1/api/account/reduceAccount")
    BaseResult<Boolean> reduceAccount(@RequestParam(name = "accountId") Long accountId,
                                    @RequestParam(name = "money") Long money);
}
