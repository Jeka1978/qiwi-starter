package com.qiwi.qiwistarter.annotations;/**
 * @author Evgeny Borisov
 */

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnExceptionHandlingCondition.class)
public @interface ConditionOnExceptionHandling {
}
