package com.qiwi.qiwistarter;

import com.qiwi.qiwistarter.aop.ExceptionHandlerAspect;
import com.qiwi.qiwistarter.bpp.InjectRandomHeroBeanPostProcessor;
import com.qiwi.qiwistarter.services.HelloWorldService;
import com.qiwi.qiwistarter.services.QiwiStatusService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableScheduling
@EnableConfigurationProperties(QiwiStarterProps.class)
@EnableAspectJAutoProxy
public class QiwiStarterConfig {

    @Bean
    @ConditionalOnProduction
    @ConditionalOnProperty(value = "qiwistarter.raven-destination")
//    @ConditionalOnProperty(value = "qiwistarter.exception-package-name")
    //todo find solution for making composite condition (exceptionHandlerAspect should be created only in case both conditions are true
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }

    @Bean
    public InjectRandomHeroBeanPostProcessor injectRandomHeroBeanPostProcessor() {
        return new InjectRandomHeroBeanPostProcessor();
    }

    @Bean
    @ConditionalOnProduction
    public HelloWorldService helloWorldService() {
        return new HelloWorldService();
    }

    @Bean
    public QiwiStatusService qiwiStatusService() {
        return new QiwiStatusService();
    }
}
