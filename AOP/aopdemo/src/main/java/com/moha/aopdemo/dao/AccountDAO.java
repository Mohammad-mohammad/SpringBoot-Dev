package com.moha.aopdemo.dao;

import com.moha.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account account, Boolean vipFlag);

    boolean doWork();
}
