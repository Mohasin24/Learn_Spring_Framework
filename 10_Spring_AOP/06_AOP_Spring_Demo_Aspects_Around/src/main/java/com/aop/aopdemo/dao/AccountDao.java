package com.aop.aopdemo.dao;

import com.aop.aopdemo.entity.Account;

import java.util.List;

public interface AccountDao
{
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
    void addAccount(Account account);
    void doWork();
    String getFirstName();
    void setFirstName(String name);
    
    String getLastName();
    void setLastName(String lastName);



}
