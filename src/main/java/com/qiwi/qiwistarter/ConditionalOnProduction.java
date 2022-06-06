package com.qiwi.qiwistarter;/**
 * @author Evgeny Borisov
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnProductionCondition.class)
public @interface ConditionalOnProduction {
}
