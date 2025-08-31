package com.payrails.helpers.api.clients;

import com.payrails.models.Configs;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchApiClient {
    private static final Logger logger = LoggerFactory.getLogger(SearchApiClient.class);
    private final Configs configs;
    private final String functionName = "SYMBOL_SEARCH";

    public SearchApiClient(Configs configs) {
        this.configs = configs;
    }

    public Response searchSymbols(List<String> keywords) {
        // Merge keywords into a single comma-separated string
        String mergedKeywords = keywords.stream()
                .map(String::trim)
                .collect(Collectors.joining(","));
        logger.debug("Initiating search for symbols with keywords: {} and function is {}", mergedKeywords, functionName);

        // Build and send the request
        return RestAssured
                .given()
                .queryParam("function", functionName)
                .queryParam("keywords", mergedKeywords)
                .queryParam("apikey", configs.getAlphaVantageApiKey())
                .when()
                .get(configs.getAlphaVantageBaseUrl())
                .then()
                .extract()
                .response();
    }
}
