package com.qiwi.qiwistarter.aop;

import com.qiwi.qiwistarter.QiwiStarterProps;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * @author Evgeny Borisov
 */
public class ExceptionHandlingCustomPointcut extends DynamicMethodMatcherPointcut {

    @Autowired
    private QiwiStarterProps props;

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return clazz -> clazz.getPackage().getName().startsWith(props.getExceptionPackageName());
    }
}


