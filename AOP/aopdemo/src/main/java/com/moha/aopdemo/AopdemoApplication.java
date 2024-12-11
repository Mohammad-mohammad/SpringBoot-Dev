package com.moha.aopdemo;

import com.moha.aopdemo.dao.AccountDAO;
import com.moha.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner -> {

			//demoTheBeforeAdvice(accountDAO, membershipDAO);

			demoTheAfterReturningAdvice(accountDAO);
		};
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterReturningAdvice: ");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		Account account = new Account();
		account.setName("Mohammad");
		account.setLevel("Master");


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
		======>>>> Logging to Cloud in async manner

		=======>>>> Executing @Before advice on method
		Method: List com.moha.aopdemo.dao.AccountDAOImpl.findAccounts()

		======>>>> Performing API Analytics
		Method: AccountDAOImpl.findAccounts()
		Returning Value: [Account{name='John', level='Silver'}, Account{name='Mary', level='Gold'}, Account{name='Peter', level='Platinum'}]


		Main program: demoTheAfterReturningAdvice:
		[Account{name='JOHN', level='Silver'}, Account{name='MARY', level='Gold'}, Account{name='PETER', level='Platinum'}]
		, Account{name='Peter', level='Platinum'}]

		*/
	}

}
