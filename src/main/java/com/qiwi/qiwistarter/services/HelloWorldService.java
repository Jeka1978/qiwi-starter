package com.qiwi.qiwistarter.services;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

public class HelloWorldService {

    @PostConstruct
    public void printMessage(){
        System.out.println("Hello Qiwi World");
    }

    public void doWork(){
        System.out.println("Qiwi forever!!!");
    }
}
