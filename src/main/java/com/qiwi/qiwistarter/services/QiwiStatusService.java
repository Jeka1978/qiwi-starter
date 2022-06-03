package com.qiwi.qiwistarter.services;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Evgeny Borisov
 */
public class QiwiStatusService {


    @Scheduled(fixedDelay = 1000)
    public void printStatus() {
        System.out.println("I'm alive...");
    }
}
