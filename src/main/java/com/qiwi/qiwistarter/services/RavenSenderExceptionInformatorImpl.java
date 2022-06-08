package com.qiwi.qiwistarter.services;

import com.qiwi.qiwistarter.QiwiStarterProps;
import com.qiwi.qiwistarter.model.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */
public class RavenSenderExceptionInformatorImpl implements RavenSenderExceptionInformator {
    @Autowired
    private QiwiStarterProps qiwiStarterProps;

    @Override
    public void inform(NotEnoughMoneyException ex) {
        System.out.println("raven sent to " + qiwiStarterProps.getRavenDestination());
        System.out.println(ex.getMessage());
    }
}
