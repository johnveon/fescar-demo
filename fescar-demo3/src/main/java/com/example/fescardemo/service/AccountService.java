package com.example.fescardemo.service;

import com.example.fescardemo.table.Account;

public interface AccountService {

    Account reduceAccount(Long accountId, Long money);
}
