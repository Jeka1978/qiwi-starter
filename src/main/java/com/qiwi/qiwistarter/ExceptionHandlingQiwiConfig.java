package com.qiwi.qiwistarter;

import com.qiwi.qiwistarter.annotations.ConditionOnExceptionHandling;
import com.qiwi.qiwistarter.aop.ExceptionHandlerAspect;
import com.qiwi.qiwistarter.aop.ExceptionHandlingCustomPointcut;
import com.qiwi.qiwistarter.services.RavenSenderExceptionInformator;
import com.qiwi.qiwistarter.services.RavenSenderExceptionInformatorImpl;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ConditionOnExceptionHandling
public class ExceptionHandlingQiwiConfig {

    @Bean
    public RavenSenderExceptionInformator ravenSenderExceptionInformator(){
        return new RavenSenderExceptionInformatorImpl();
    }
    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }

    @Bean
    public ExceptionHandlingCustomPointcut exceptionHandlingCustomPointcut(){
        return new ExceptionHandlingCustomPointcut();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisorForBankException() {
        return new DefaultPointcutAdvisor(exceptionHandlingCustomPointcut(), exceptionHandlerAspect());
    }
}
