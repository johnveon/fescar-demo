package com.example.fescardemo.service.restful;


import com.example.fescardemo.common.web.BaseResult;
import com.example.fescardemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account/v1/api/account")
public class AccountProvider {

    @Autowired
    private AccountService accountService;

    @GetMapping("/reduceAccount")
    public BaseResult<Boolean> reduceAccount(@RequestParam(name = "accountId") Long accountId,
                                             @RequestParam(name = "money") Long money){
        accountService.reduceAccount(accountId, money);
        return BaseResult.success(true);
    }

}
