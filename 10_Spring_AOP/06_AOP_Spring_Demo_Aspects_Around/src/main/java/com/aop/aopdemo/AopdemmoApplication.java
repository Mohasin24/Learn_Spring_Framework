package com.aop.aopdemo;

import com.aop.aopdemo.dao.AccountDao;
import com.aop.aopdemo.dao.MembershipDao;
import com.aop.aopdemo.entity.Account;
import com.aop.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao, TrafficFortuneService trafficFortuneService){
		return runner->{
//			demoTheBeforeAdvice(accountDao,membershipDao);
//			demoTheAfterReturningAdvice(accountDao);
//			demoTheAfterThrowingAdvice(accountDao);
//			demoTheAfterAdvice(accountDao);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceExceptionHandling(trafficFortuneService);
			demoTheAroundAdviceReThrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceReThrowException(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\nMain program : demoTheAroundAdviceExceptionHandling");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is : " + data);
		System.out.println("Finished!");
	}

	private void demoTheAroundAdviceExceptionHandling(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\nMain program : demoTheAroundAdviceExceptionHandling");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is : " + data);
		System.out.println("Finished!");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService)
	{
		System.out.println("\nMain program : demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is : " + data);
		System.out.println("Finished!");
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
