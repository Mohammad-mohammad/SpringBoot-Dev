package com.moha.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.moha.aopdemo.aspect.AopExpression.forDaoPackageNoGetterSetter()")
    public void performAPIAnalytics(){
        System.out.println("\n======>>>> Performing API Analytics");
    }
}
