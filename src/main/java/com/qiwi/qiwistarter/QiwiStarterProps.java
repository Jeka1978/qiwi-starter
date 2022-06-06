package com.qiwi.qiwistarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Evgeny Borisov
 */
@ConfigurationProperties(prefix = "qiwistarter")
@Data
public class QiwiStarterProps {
    private String helloMessage;

    private String ravenDestination;

    private String exceptionPackageName;

}
