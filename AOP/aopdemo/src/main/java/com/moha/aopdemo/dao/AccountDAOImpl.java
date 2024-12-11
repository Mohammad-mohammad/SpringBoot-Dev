package com.moha.aopdemo.dao;

import com.moha.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass()+": Doing my DB work - Adding an account.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": Doing my work.");
        return false;
    }
}
