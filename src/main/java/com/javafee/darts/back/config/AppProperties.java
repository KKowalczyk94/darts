package com.javafee.darts.back.config;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@UtilityClass
public class AppProperties {
    public Properties PROPS;

    static {
        PROPS = new Properties();
        try (InputStream is
                     = AppProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPS.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object value(String key) {
        return PROPS.get(key);
    }
}
