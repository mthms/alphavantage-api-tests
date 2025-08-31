package api;

import base.BaseTest;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.testng.Reporter;
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
        searchApiClient.get().searchSymbols(Arrays.asList("TSLA"))
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("bestMatches", notNullValue())
                .body("bestMatches", instanceOf(List.class))
                .body("bestMatches.size()", greaterThan(0));
        Reporter.log("Search API responded with 200 status code for valid query and " +
                "bestMatches array exists with results", true);
    }
}
