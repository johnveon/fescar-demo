package com.example.fescardemo.repository;

import com.example.fescardemo.table.Account;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(500L);
        Account save = accountRepository.save(account);
        Long accountId = save.getAccountId();

        Assert.assertThat(accountId, CoreMatchers.notNullValue());
    }

}