package com.aop.aopdemo.dao;

import com.aop.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao
{
    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire)
    {
        // for learning purpose throw the exception

        if(tripWire)
        {
            throw new RuntimeException("Demo for AfterThrowing advice");
        }

        List<Account> list = new ArrayList<>();

        Account temp1 = new Account("Mohasin","Patel");
        Account temp2 = new Account("Susan","Hill");
        Account temp3 = new Account("Ravi","Sharma");

        list.add(temp1);
        list.add(temp2);
        list.add(temp3);

        return list;
    }

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
