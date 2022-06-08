package com.qiwi.qiwistarter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
public class ProfileDetectorApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        String[] activeProfiles = applicationContext.getEnvironment().getActiveProfiles();
        if (activeProfiles.length == 0) {
            throw new IllegalStateException("can't start application without active profile. Consider between WINTER_IS_COMING and WINTER_IS_HERE");
        }
    }
}
