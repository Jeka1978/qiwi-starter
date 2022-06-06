package com.qiwi.qiwistarter;

import com.qiwi.qiwistarter.services.HelloWorldService;
import com.qiwi.qiwistarter.services.QiwiStatusService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Evgeny Borisov
 */
@Configuration
@EnableScheduling
public class QiwiStarterConfig {
    @Bean
    @ConditionalOnProduction
    public HelloWorldService helloWorldService(){
        return new HelloWorldService();
    }
    @Bean
    public QiwiStatusService qiwiStatusService(){
        return new QiwiStatusService();
    }
}
