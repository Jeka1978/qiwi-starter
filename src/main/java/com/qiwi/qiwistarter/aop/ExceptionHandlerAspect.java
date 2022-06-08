package com.qiwi.qiwistarter.aop;

import com.qiwi.qiwistarter.model.NotEnoughMoneyException;
import com.qiwi.qiwistarter.services.RavenSenderExceptionInformator;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Evgeny Borisov
 */

public class ExceptionHandlerAspect implements MethodInterceptor {


    private Map<NotEnoughMoneyException, Void> cache = new WeakHashMap<>();
    @Autowired
    private RavenSenderExceptionInformator raven;



    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object retVal;
        try {
            retVal = invocation.proceed();
        } catch (NotEnoughMoneyException ex) {
            if (!cache.containsKey(ex)) {
                cache.put(ex, null);
                raven.inform(ex);
            }
            throw ex;
        }

        return retVal;
    }
}

