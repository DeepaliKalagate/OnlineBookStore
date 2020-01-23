
/******************************************************************************
 *
 *  Author  Deepali Kalagate
 *  Purpose: Setting the URL.
 *
 *  @since   18-01-2020
 *
 ******************************************************************************/

package com.bridgelabz.onlinebookstore;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTest
{
    @Before
    public void setUp()
    {
        RestAssured.baseURI="http://192.168.0.167:8080/books";
    }
}
