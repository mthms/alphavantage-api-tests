package com.payrails.helpers;

import com.payrails.models.Configs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigHelper {
    private static final Logger logger = LoggerFactory.getLogger(ConfigHelper.class);

    public Configs readConfigs(Configs configs){
        logger.info("Initiating the main configs reading process...");

        logger.info("Finalized reading the main configs successfully.");
        return configs;
    }
}
