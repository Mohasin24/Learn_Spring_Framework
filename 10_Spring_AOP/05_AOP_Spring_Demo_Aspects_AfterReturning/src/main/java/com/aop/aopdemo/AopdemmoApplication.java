package com.aop.aopdemo;

import com.aop.aopdemo.dao.AccountDao;
import com.aop.aopdemo.dao.MembershipDao;
import com.aop.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemmoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner->{
//			demoTheBeforeAdvice(accountDao,membershipDao);
//			demoTheAfterReturningAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
			demoTheAfterAdvice(accountDao);
		};
	}

	private void demoTheAfterAdvice(AccountDao accountDao)
	{
		List<Account> theAccounts = null;

		try{
			boolean tripWire = false;
			theAccounts = accountDao.findAccounts(tripWire);
		}catch (Exception exc)
		{
			System.out.println("\n\n====>>>> Exception caught" + exc);
		}

		System.out.println("===>>> Main program : "+ theAccounts);
		System.out.println("======>>> End of main program\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDao accountDao)
	{
		List<Account> theAccounts = null;

		try{
			boolean tripWire = true;
			theAccounts = accountDao.findAccounts(true);
		}catch (Exception exc)
		{
			System.out.println("\n\n====>>>> Exception caught" + exc);
		}

		System.out.println("===>>> Main program : "+ theAccounts);
		System.out.println("======>>> End of main program\n");
	}

	private void demoTheAfterReturningAdvice(AccountDao accountDao)
	{
		System.out.println("===>>> Main program : ");
		System.out.println("\n\n====>>>>" + accountDao.findAccounts());
		System.out.println("======>>> End of main program\n");
	}

	private void demoTheBeforeAdvice(AccountDao accountDao, MembershipDao membershipDao)
	{
		Account account = new Account("Mohasin","Patel");
		accountDao.addAccount(account);
		accountDao.doWork();
		accountDao.getFirstName();
		accountDao.setFirstName("Mohasin");
		accountDao.getLastName();
		accountDao.setLastName("Patel");
//		membershipDao.addMember();
//		membershipDao.goToSleep();
	}
}
