package com.moha.aopdemo.dao;

import com.moha.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount(Account account, Boolean vipFlag) {
        System.out.println(getClass()+": Doing my DB work - Adding an account.");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass()+": Doing my work.");
        return false;
    }

    public String getName() {
        System.out.println(getClass()+": get Name");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+": set Name");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": get Service code");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+": set Service code");
        this.serviceCode = serviceCode;
    }

    @Override
    public List<Account> findAccounts() {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("John", "Silver"));
        accounts.add(new Account("Mary", "Gold"));
        accounts.add(new Account("Peter", "Platinum"));

        return accounts;
    }
}
