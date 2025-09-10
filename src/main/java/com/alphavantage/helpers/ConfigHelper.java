package com.alphavantage.helpers;

import com.alphavantage.models.Configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConfigHelper.class);

    public Configs readConfigs(Configs configs){
        logger.info("Initiating the main configs reading process...");

        File mainConfigs = new File("resources/environments/config_"
                + System.getProperty("env", "testing").toLowerCase()
                + ".properties");

        try {
            logger.info("Reading main configs...");
            FileReader fileReader = new FileReader(mainConfigs);
            Properties properties = new Properties();
            properties.load(fileReader);
            configs.setAlphaVantageApiKey(getPropertyValueOrDefault(properties, "alphaVantageApiKey", ""));
            configs.setAlphaVantageBaseUrl(getPropertyValueOrDefault(properties, "alphaVantageBaseUrl", ""));
        } catch (Exception e){
            logger.error("Reading main config file failed. Killing the test...", e);
        }

        logger.info("Finalized reading the main configs successfully.");
        return configs;
    }

    public String getPropertyValueOrDefault(Properties properties, String keyName, String defaultValue){
        if (properties.getProperty( keyName, defaultValue).isEmpty())
            return defaultValue;
        else
            return properties.getProperty( keyName, defaultValue);
    }
}
