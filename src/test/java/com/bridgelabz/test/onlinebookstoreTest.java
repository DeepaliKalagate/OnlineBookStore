package com.bridgelabz.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class onlinebookstoreTest
{
    @Before
    public void setUp()
    {
        RestAssured.baseURI="http://192.168.0.167:8080/books";
    }

    @Test
    public void givenToken_ShouldReturnAllRedirectData()
    {
        Response response=RestAssured.given()
                .accept(ContentType.ANY)
                .when()
                .get("/showBooks");
        int status=response.getStatusCode();
        String string = response.asString();
        System.out.println(string);
        MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
    }
}
