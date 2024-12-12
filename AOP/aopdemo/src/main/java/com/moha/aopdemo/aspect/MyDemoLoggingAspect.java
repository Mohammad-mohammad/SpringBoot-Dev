package com.moha.aopdemo.aspect;

import com.moha.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.moha.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("\n=======>>>> Executing @Around advice on method "+ proceedingJoinPoint.getSignature().toShortString());

        long begin = System.currentTimeMillis();
        Object result = null;

        try {
            result= proceedingJoinPoint.proceed();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
        long end= System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n=====>> Duration: "+duration/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.moha.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        System.out.println("\n=======>>>> Executing @AfterFinally advice on method "+ joinPoint.getSignature().toShortString());
    }

    @AfterThrowing(
            pointcut = "execution(* com.moha.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable theExc){

        System.out.println("\n=======>>>> Executing @AfterThrowing advice on method "+ joinPoint.getSignature().toShortString());

        System.out.println("The Exception is: "+ theExc);
    }

    @AfterReturning(
            pointcut = "execution(* com.moha.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        System.out.println("Method: "+ joinPoint.getSignature().toShortString());

        System.out.println("Returning Value: "+result);

        convertAccountsNamesToUpperCase(result);
    }

    private void convertAccountsNamesToUpperCase(List<Account> result) {

        for (Account account : result){
            account.setName(account.getName().toUpperCase());
        }

    }

    @Before("com.moha.aopdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n=======>>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+ signature);

        // display method arguments
        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            System.out.println("Argument: "+ arg);
            if(arg instanceof Account account){
                System.out.println("Account name: "+ account.getName());
                System.out.println("Account level: "+ account.getLevel());
            }
        }
    }

}
