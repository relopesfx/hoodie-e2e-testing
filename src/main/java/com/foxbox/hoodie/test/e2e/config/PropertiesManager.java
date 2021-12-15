package com.foxbox.hoodie.test.e2e.config;

import org.aeonbits.owner.ConfigFactory;

public class PropertiesManager {

    private static Properties properties;

    private PropertiesManager() {

    }

    public static Properties get() {
        if (properties == null) {
            properties = ConfigFactory.create(Properties.class);
        }

        return properties;
    }
}
