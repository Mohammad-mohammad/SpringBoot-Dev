package com.moha.aopdemo.dao;

import com.moha.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, Boolean vipFlag);

    boolean doWork();

    String getName() ;

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode) ;

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);
}
