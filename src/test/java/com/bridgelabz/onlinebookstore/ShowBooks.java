
/******************************************************************************
 *
 *  Author  Deepali Kalagate and Shivanjali Sangale
 *  Purpose: Test for Show book.
 *
 *  @since   18-01-2020
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

public class ShowBooks extends BaseTest
{
    @Test
    public void givenShowBooksURL_WhenCorrectURL_ThenShouldReturnListOfBooks()
    {
        try
        {
            Response response=RestAssured.given()
                    .accept(ContentType.JSON)
                    .when()
                    .get("showBooks");
            int status=response.getStatusCode();
            ResponseBody body = response.getBody();
            Object Object = new JSONParser().parse(body.prettyPrint());
            String string = response.asString();
            System.out.println(string);
            MatcherAssert.assertThat(status, Matchers.equalTo(HttpStatus.SC_OK));
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }
}
