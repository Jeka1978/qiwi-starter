package com.qiwi.qiwistarter.services;

import com.qiwi.qiwistarter.QiwiStarterProps;
import com.qiwi.qiwistarter.model.NotEnoughMoneyException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Evgeny Borisov
 */

public interface RavenSenderExceptionInformator {

    void inform(NotEnoughMoneyException ex);

}
