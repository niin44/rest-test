/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;
import se.nackademin.rest.test.model.Book;
import se.nackademin.rest.test.model.SingleBook;

/**
 *
 * @author niin
 */
public class TestPut {
    private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";
    
    @Test
    public void testUpdateBook(){
        Response postResponse = new BookOperations().createRandomBook();
        assertEquals("post response should have status code 201",201,postResponse.statusCode());
        
        Response getResponse = new BookOperations().getAllBooks();
        int fetchedId = getResponse.jsonPath().getInt("books.book[-1].id");
        
        Response updateResponse = new BookOperations().updateBook(fetchedId);
        assertEquals("delete methodo should return 204", 204, updateResponse.getStatusCode());
        
        Response getUpdatedBookResponse = new BookOperations().getBook(fetchedId);
        assertEquals("fetching delted book should return 404", 404, getUpdatedBookResponse.getStatusCode());
        
        
    }
    @Test
    public void testUpdateBooksAuthor(){
        
    }
    @Test
    public void testUpdateAuthors(){
        
    }
    //HTTP status code 404
    //The book was not found.
    @Test
    public void testBook404(){
            
    }
    //HTTP status code 400
    //The book contained an author with no id field set or the book contained an author that didn't exist in the database.
    @Test
    public void testBook400(){
        
    }
}
