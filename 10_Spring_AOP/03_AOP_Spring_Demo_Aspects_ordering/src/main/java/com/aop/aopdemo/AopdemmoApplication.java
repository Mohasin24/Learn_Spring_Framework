package com.aop.aopdemo;

import com.aop.aopdemo.dao.AccountDao;
import com.aop.aopdemo.dao.MembershipDao;
import com.aop.aopdemo.entity.Account;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemmoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao){
		return runner->{
			demoTheBeforeAdvice(accountDao,membershipDao);
		};
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
