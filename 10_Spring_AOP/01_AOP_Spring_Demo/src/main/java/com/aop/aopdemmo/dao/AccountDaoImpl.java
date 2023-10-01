package com.aop.aopdemmo.dao;

import com.aop.aopdemmo.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao
{
    @Override
    public void addAccount(Account account)
    {
        System.out.println(getClass() + " : Doing my DB work : Adding an account");
    }

    @Override
    public void doWork() {
        System.out.println(getClass() + " : doWork() ");
    }
}
