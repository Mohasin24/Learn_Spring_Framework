package com.aop.aopdemmo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao
{
    @Override
    public boolean addMember()
    {
        System.out.println(getClass() + " : Doing my DB work : Adding a membership account");return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : goToSleep()");
    }
}
