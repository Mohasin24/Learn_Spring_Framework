package com.aop.aopdemo.dao;

import com.aop.aopdemo.entity.Account;
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

    @Override
    public String getFirstName() {
        System.out.println(getClass() + " : Inside getName ");
        return null;
    }

    @Override
    public void setFirstName(String name)
    {
        System.out.println(getClass() + " : Inside setName ");
    }

    @Override
    public String getLastName()
    {
        System.out.println(getClass() + " : Inside getLastName ");
        return null;
    }

    @Override
    public void setLastName(String lastName)
    {
        System.out.println(getClass() + " : Inside setLastName ");
    }
}
