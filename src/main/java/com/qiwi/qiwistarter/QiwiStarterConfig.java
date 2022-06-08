package com.qiwi.qiwistarter;

import com.qiwi.qiwistarter.aop.ExceptionHandlerAspect;
import com.qiwi.qiwistarter.aop.ExceptionHandlingCustomPointcut;
import com.qiwi.qiwistarter.bpp.InjectRandomHeroBeanPostProcessor;
import com.qiwi.qiwistarter.services.HelloWorldService;
import com.qiwi.qiwistarter.services.QiwiStatusService;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableScheduling
@EnableConfigurationProperties(QiwiStarterProps.class)
@EnableAspectJAutoProxy
@Import(LegacyBeanDefinitionRegistrar.class)
public class QiwiStarterConfig {



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

