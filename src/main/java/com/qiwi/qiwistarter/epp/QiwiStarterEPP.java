package com.qiwi.qiwistarter.epp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class QiwiStarterEPP implements EnvironmentPostProcessor {


    static {
        System.setProperty("java.awt.headless", "false");
    }

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        if (environment.getActiveProfiles().length == 0) {
            if (getTemperature() < -50) {
                environment.addActiveProfile("WINTER_IS_HERE");
            }else {
                environment.setActiveProfiles("WINTER_IS_COMING");
            }
        }
        Map<String, Object> customPropertyMap = new HashMap<>();

        customPropertyMap.put("qiwi.location", "Moscow");


        MapPropertySource customPropertySource = new MapPropertySource("qiwi_properties", customPropertyMap);


        environment.getPropertySources().addFirst(customPropertySource);

    }





    private int getTemperature(){
        return -55;
    }

}
