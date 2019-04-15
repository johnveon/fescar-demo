package com.example.fescardemo.service.restful;

import com.example.fescardemo.common.web.BaseResult;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountProviderTest {

    @Autowired
    private AccountProvider accountProvider;


    @Test
    public void reduceAccount() {

        BaseResult<Boolean> result = accountProvider.reduceAccount(32L, 100L);
        Boolean data = result.getData();
        Assert.assertThat(data, CoreMatchers.is(true));
    }
}