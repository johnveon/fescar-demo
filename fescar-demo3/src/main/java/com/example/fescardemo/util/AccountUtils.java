package com.example.fescardemo.util;

import com.example.fescardemo.model.vo.AccountVO;
import com.example.fescardemo.table.Account;

public class AccountUtils {

    public static Account voToModel(AccountVO vo) {
        Account model = new Account();
        model.setAccountId(vo.getAccountId());
        model.setMoney(vo.getMoney());
        return model;
    }
}
