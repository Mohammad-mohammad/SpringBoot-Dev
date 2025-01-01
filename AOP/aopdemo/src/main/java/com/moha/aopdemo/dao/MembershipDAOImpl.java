package com.moha.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addAccount() {
        System.out.println(getClass()+": Doing my DB work - Adding an membership.");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass()+ ": I am going to sleep now...");
    }
}
