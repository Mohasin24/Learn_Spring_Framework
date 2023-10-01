package com.aop.aopdemmo.dao;

import com.aop.aopdemmo.entity.Account;

public interface AccountDao
{
    void addAccount(Account account);

    void doWork();
}
