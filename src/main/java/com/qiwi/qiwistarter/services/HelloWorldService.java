package com.qiwi.qiwistarter.services;

import com.qiwi.qiwistarter.QiwiStarterProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Evgeny Borisov
 */

public class HelloWorldService {

    @Autowired
    private QiwiStarterProps props;


    @PostConstruct
    public void printMessage(){
        System.out.println(props.getHelloMessage());
    }

    public void doWork(){
        System.out.println("Qiwi forever!!!");
    }
}
