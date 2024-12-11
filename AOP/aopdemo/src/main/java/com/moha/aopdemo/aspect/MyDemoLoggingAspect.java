package com.moha.aopdemo.aspect;

import com.moha.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
