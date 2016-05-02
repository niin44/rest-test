/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import org.junit.Test;
import static org.junit.Assert.*;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

/**
 *
 * @author niin
 */
public class MyFirstRestTest {
    private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";
    public MyFirstRestTest() {
    }
    
    @Test
    public void testFetchBook(){
        String resourceName = "books/3";
        Response response = given().accept(ContentType.JSON).log().all().get(BASE_URL+resourceName);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals("Status code should be 200", 200, response.statusCode());
    }
        @Test
    public void testFetchInvalidBookReturns404(){
        String resourceName = "books/333333";
        Response response = given().accept(ContentType.JSON).log().all().get(BASE_URL+resourceName);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals("Status code should be 404", 404, response.statusCode());
    }
    
}
