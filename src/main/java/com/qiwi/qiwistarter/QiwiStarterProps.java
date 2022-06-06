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
    private int version;
    private String productName;

}
