package api;

import base.BaseTest;
import io.qameta.allure.*;
import net.datafaker.Faker;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

@Test
public class SearchApiTests extends BaseTest {
    @Feature("Symbol Search")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Search API should always respond with 200 status code")
    @Test
    public void validateSearchApiResponseIsSuccessfulWhenQueryIsValid(){
        defaultTestData.get().setSearchKeywords(Arrays.asList("TSLA"));
        searchApiClient.get().searchSymbols(defaultTestData.get().getSearchKeywords())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("bestMatches", notNullValue())
                .body("bestMatches", instanceOf(List.class))
                .body("bestMatches.size()", greaterThan(0));
        logger.get().info("Search API responded with 200 status code for valid query " +
                "\"{}\" and bestMatches array exists with results", defaultTestData.get().getSearchKeywords());
    }

    @Feature("Symbol Search")
    @Severity(SeverityLevel.NORMAL)
    @Story("Search API should always respond with 200 status code")
    @Test
    public void validateSearchApiResponseIsCorrectWhenQueryIsInValid(){
        defaultTestData.get().setSearchKeywords(Arrays.asList(new Faker().lorem().characters(5)));
        searchApiClient.get().searchSymbols(defaultTestData.get().getSearchKeywords())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("bestMatches", notNullValue())
                .body("bestMatches", instanceOf(List.class))
                .body("bestMatches.size()", equalTo(0));
        logger.get().info("Search API responded with 200 status code for InValid query \"{}\" " +
                "and bestMatches array exists with 0 results", defaultTestData.get().getSearchKeywords());
    }
}
