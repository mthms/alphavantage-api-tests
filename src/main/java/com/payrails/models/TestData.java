package com.payrails.models;

import io.restassured.path.json.JsonPath;

import java.util.ArrayList;
import java.util.List;

public class TestData {
    private JsonPath jsonPath;
    private List<String> searchKeywords = new ArrayList<>();

    public JsonPath getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(JsonPath jsonPath) {
        this.jsonPath = jsonPath;
    }

    public List<String> getSearchKeywords() {
        return searchKeywords;
    }

    public void setSearchKeywords(List<String> searchKeywords) {
        this.searchKeywords = searchKeywords;
    }
}
