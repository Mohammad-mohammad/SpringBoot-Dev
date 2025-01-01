package com.moha.aopdemo;

import com.moha.aopdemo.dao.AccountDAO;
import com.moha.aopdemo.dao.MembershipDAO;
import com.moha.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){
		return runner -> {

			//demoTheBeforeAdvice(accountDAO, membershipDAO);

			//demoTheAfterReturningAdvice(accountDAO);

			//demoTheAfterThrowingAdvice(accountDAO);

			//demoTheAfterAdvice(accountDAO);

			//demoTheAroundAdvice(trafficFortuneService);

			//demoTheAroundAdviceHandleException(trafficFortuneService);

			demoThrAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoThrAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoThrAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		System.out.println("\nMy fortune is: "+ trafficFortuneService.getFortune(tripWire));

		System.out.println("Finished");

		// Result:
		/*
			Main Program: demoThrAroundAdviceRethrowException
			Calling getFortune()

			=======>>>> Executing @Around advice on method TrafficFortuneServiceImpl.getFortune(..)
			Major accident! Highway is closed!
			2024-12-12T11:39:15.444+01:00 ERROR 7784 --- [aopdemo] [           main] o.s.boot.SpringApplication               : Application run failed

			java.lang.RuntimeException: Major accident! Highway is closed!
				at com.moha.aopdemo.service.TrafficFortuneServiceImpl.getFortune(TrafficFortuneServiceImpl.java:23) ~[classes/:na]
				at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
				at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]


		*/
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		System.out.println("\nMy fortune is: "+ trafficFortuneService.getFortune(tripWire));

		System.out.println("Finished");

		// Result:
		/*
			Main Program: demoTheAroundAdviceHandleException
			Calling getFortune()

			=======>>>> Executing @Around advice on method TrafficFortuneServiceImpl.getFortune(..)
			Major accident! Highway is closed!

			=====>> Duration: 0.007 seconds

			My fortune is: Major accident! But no worries, your private AOP helicopter is on the way.
			Finished

		*/
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");
		System.out.println("\nMy fortune is: "+ trafficFortuneService.getFortune());
		System.out.println("Finished");


		// Result:
		/*
		Main Program: demoTheAroundAdvice
		Calling getFortune()

		=======>>>> Executing @Around advice on method TrafficFortuneServiceImpl.getFortune()

		=====>> Duration: 5.013 seconds

		My fortune is: Expect heavy traffics this morning
		Finished

		*/
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try{
			boolean tripWire = true;
			accounts= accountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\nMain Program: ... caught the exception "+ e);
		}

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice: ");
		System.out.println(accounts);

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;

		try{
			boolean tripWire = true;
			accounts= accountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\nMain Program: ... caught the exception "+ e);
		}

		// display the accounts
		System.out.println("\n\nMain program: demoTheAfterThrowingAdvice: ");
		System.out.println(accounts);
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

	}

}
