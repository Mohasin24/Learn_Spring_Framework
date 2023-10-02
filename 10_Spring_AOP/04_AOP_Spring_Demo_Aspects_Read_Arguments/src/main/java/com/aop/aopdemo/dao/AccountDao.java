package com.aop.aopdemo.dao;

import com.aop.aopdemo.entity.Account;

public interface AccountDao
{
    void addAccount(Account account);
    void doWork();
    String getFirstName();
    void setFirstName(String name);
    
    String getLastName();
    void setLastName(String lastName);
}
