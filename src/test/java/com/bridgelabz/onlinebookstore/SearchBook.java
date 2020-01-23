/******************************************************************************
 *
 *  Author  Deepali Kalagate and Shivanjali Sangale
 *  Purpose: Test for Search Book by Author and BookName .
 *
 *  @since 23-01-2020
 *
 ******************************************************************************/
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

public class SearchBook extends BaseTest {

    @Test
    public void givenListOfBooks_WhenSearchByCorrectFirstAuthor_ThenShouldReturnBookByAuthor() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=Chetan Bhagat");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByCorrectSecondAuthor_ThenShouldReturnBookByAuthor() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=Dan Brown");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByIncorrectAuthor_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=SaneGuruji");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByCorrectFirstBookName_ThenShouldReturnBookByBookName() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=Angels And Demons");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByCorrectSecondBookName_ThenShouldReturnBookByBookName() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=The Da Vinci Code");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByIncorrectBookName_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=The Times Of India");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenListOfBooks_WhenSearchByInvalidBookName_ThenShouldThrowException() {
        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("searchByAuthorOrTitle?searchElement=9874");
            int status = response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
