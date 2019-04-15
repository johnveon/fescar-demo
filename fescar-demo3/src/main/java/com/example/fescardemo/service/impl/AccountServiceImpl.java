package com.example.fescardemo.service.impl;

import com.example.fescardemo.repository.AccountRepository;
import com.example.fescardemo.service.AccountService;
import com.example.fescardemo.table.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account reduceAccount(Long accountId, Long money) {
        Account one = accountRepository.getOne(accountId);
        one.setMoney((one.getMoney() - money));
        accountRepository.save(one);

        boolean b = true;
        if (b){
            throw new RuntimeException("账户扣减失败");
        }

        return one;
    }
}
