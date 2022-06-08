package com.qiwi.qiwistarter.annotations;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Condition;

/**
 * @author Evgeny Borisov
 */
public class OnExceptionHandlingCondition extends AllNestedConditions {
    public OnExceptionHandlingCondition() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }

    @ConditionalOnProperty("qiwistarter.raven-destination")
    static class DestinationExistsCondition{}

    @ConditionalOnProperty("qiwistarter.exception-package-name")
    static class PackageForExceptionsExistsCondition{}

}
