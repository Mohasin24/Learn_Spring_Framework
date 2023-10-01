package com.aop.aopdemmo;

import com.aop.aopdemmo.dao.AccountDao;
import com.aop.aopdemmo.dao.MembershipDao;
import com.aop.aopdemmo.entity.Account;
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

		membershipDao.addMember();
		membershipDao.goToSleep();
	}
}
