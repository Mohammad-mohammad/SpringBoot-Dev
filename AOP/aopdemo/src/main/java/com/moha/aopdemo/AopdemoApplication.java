package com.moha.aopdemo;

import com.moha.aopdemo.dao.AccountDAO;
import com.moha.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {

			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		accountDAO.setName("Hello");
		accountDAO.setServiceCode("Silver");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

		membershipDAO.addAccount();
		membershipDAO.goToSleep();


		// Result:
		/*
		=======>>>> Executing @Before advice on method

		======>>>> Performing API Analytics
		class com.moha.aopdemo.dao.AccountDAOImpl: Doing my DB work - Adding an account.

		=======>>>> Executing @Before advice on method

		======>>>> Performing API Analytics
		class com.moha.aopdemo.dao.AccountDAOImpl: Doing my work.
		class com.moha.aopdemo.dao.AccountDAOImpl: set Name
		class com.moha.aopdemo.dao.AccountDAOImpl: set Service code
		class com.moha.aopdemo.dao.AccountDAOImpl: get Name
		class com.moha.aopdemo.dao.AccountDAOImpl: get Service code

		=======>>>> Executing @Before advice on method

		======>>>> Performing API Analytics
		class com.moha.aopdemo.dao.MembershipDAOImpl: Doing my DB work - Adding an membership.

		=======>>>> Executing @Before advice on method

		======>>>> Performing API Analytics
		class com.moha.aopdemo.dao.MembershipDAOImpl: I am going to sleep now...

		*/
	}

}
