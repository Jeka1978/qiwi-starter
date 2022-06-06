package com.qiwi.qiwistarter.aop;

import com.qiwi.qiwistarter.QiwiStarterProps;
import com.qiwi.qiwistarter.model.NotEnoughMoneyException;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author Evgeny Borisov
 */
@Aspect
public class ExceptionHandlerAspect {
    @Autowired
    private QiwiStarterProps qiwiStarterProps;

    private HashMap<NotEnoughMoneyException, Void> cache = new HashMap<>();


    //TODO PACKAGE NAME SHOULD BE TAKEN FROM application.yaml of project
    @AfterThrowing(pointcut = "execution(* com.qiwi..*.*(..))", throwing = "ex")
    public void handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
        if (!cache.containsKey(ex)) {
            cache.put(ex, null);
            System.out.println("raven sent to " + qiwiStarterProps.getRavenDestination());
            System.out.println(ex.getMessage());
        }
    }


}
