package com.example.fescardemo.table;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "t_account_account")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "money")
    private Long money;
}
