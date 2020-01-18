package com.bridgelabz.onlinebookstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.apache.http.HttpStatus;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class OrderConfirmation
{
    @Before
    public void setUp()
    {
        RestAssured.baseURI="http://192.168.0.167:8080/books";
    }

    @Test
    public void givenURL_WhenGivenId_ThenShouldReturnBookById()
    {
        try
        {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .body("{\"id\" :\"5\",\"customerName\" :\"Customerame\",\"mobileNumber\" : \"91 8793432373\",\"pincode\" :\"411 011\",\"address\" :\"dhjasgdas\",\"city\" :\"City\",\"country\" :\"India\"}")
                    .post("/orderConfirmation/5");
            int status=response.getStatusCode();
            ResponseBody body = response.getBody();
            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
