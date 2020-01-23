
/******************************************************************************
 *
 *  Author  Deepali Kalagate and Shivanjali Sangale
 *  Purpose: Testcase for get book detail by Id.
 *
 *  @since   19-01-2020
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

public class GetBookDetailById extends BaseTest
{
    @Test
    public void givenURL_WhenGivenId_ThenShouldReturnBookById()
    {
        try
        {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("getBookDetail/1?country=india");
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

    @Test
    public void givenURL_WhenGivenWrongId_ThenShouldReturnMessage()
    {
        try
        {
            Response response=RestAssured.given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .when()
                    .get("getBookDetail/100?country=india");
            int status=response.getStatusCode();
            ResponseBody body = response.getBody();
            JSONObject Object = (JSONObject) new JSONParser().parse(body.prettyPrint());
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_INTERNAL_SERVER_ERROR));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
