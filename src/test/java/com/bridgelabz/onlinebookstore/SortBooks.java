package com.bridgelabz.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class SortBooks extends BaseTest {

    //sort by price in ascending order
    @Test
    public void givenListOfBooks_WhenSortByPrice_ThenShouldReturnBookInAscendingOrderOfPrice() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("sortByPrice?sortType=price");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSortByPriceProvideAnyNumber_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("sortByPrice?sortType=400");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSortByPriceProvideAlphanumericValue_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("sortByPrice?sortType=550/-");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    //sort books by title
    @Test
    public void givenListOfBooks_WhenSortByTitle_ThenShouldReturnBooksByTitle() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get(" sortByPrice?sortType=title");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSortByTitleByAlphanumericValue_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get(" sortByPrice?sortType=11/22/63");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenListOfBooks_WhenNoValueProvidedForSort_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get(" sortByPrice?sortType=");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
