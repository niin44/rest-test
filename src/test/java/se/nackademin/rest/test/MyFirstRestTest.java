/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import se.nackademin.rest.test.model.*;

/**
 *
 * @author niin
 */
public class MyFirstRestTest {
    private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";
    public MyFirstRestTest() {
    }
    ///* Previous code
    @Test
    public void testFetchBook(){
        Book book = given().accept(ContentType.JSON).get(BASE_URL + "books/4").jsonPath().getObject("book", Book.class);
        System.out.println(book.getDescription());
    }
    @Test
    public void testCreateNewBook(){
        Book book = new Book();
        book.setDescription("Hello");
        book.setTitle("Happy");
        book.setIsbn("123123");
        book.setNbOfPage(2356);
        SingleBook singleBook = new SingleBook(book);
        Response response = given().contentType(ContentType.JSON).body(singleBook).log().all().post(BASE_URL+"books").prettyPeek();
        System.out.println("Status code: " + response.getStatusCode()); 
    }
    
    /****
    @Test
    public void testFetchBook(){
        Response response = new BookOperations().getBook(3);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals("Status code should be 200", 200, response.statusCode());
    }
        @Test
    public void testFetchInvalidBookReturns404(){
        Response response = new BookOperations().getBook(123333);
        System.out.println("Status code: " + response.getStatusCode());
        assertEquals("Status code should be 404", 404, response.statusCode());
    }
    @Test
    public void testAddNewBook() {
        BookOperations bookOperations = new BookOperations();
        Response postResponse = bookOperations.createRandomBook();
        assertEquals("post response should have status code 201", 201, postResponse.statusCode());
        

        String  expectedTitle = from(bookOperations.getLatestJsonString()).getString("book.title");
        String  expectedDescription = from(bookOperations.getLatestJsonString()).getString("book.description");
        String  expectedIsbn = from(bookOperations.getLatestJsonString()).getString("book.isbn");
        
        Response getResponse = bookOperations.getAllBooks();
        String fetchedTitle = getResponse.jsonPath().getString("books.book[-1].title");
        String fetchedDescription = getResponse.jsonPath().getString("books.book[-1].description");
        String fetchedIsbn = getResponse.jsonPath().getString("books.book[-1].isbn");
        
        assertEquals(expectedTitle, fetchedTitle);
        assertEquals(expectedDescription,fetchedDescription);
        assertEquals(expectedIsbn,fetchedIsbn);
    }
    
    @Test
    public void testDeleteBook(){
        Response postResponse = new BookOperations().createRandomBook();
        assertEquals("post response should have status code 201",201,postResponse.statusCode());
        
        Response getResponse = new BookOperations().getAllBooks();
        int fetchedId = getResponse.jsonPath().getInt("books.book[-1].id");
        
        Response deleteResponse = new BookOperations().deleteBook(fetchedId);
        assertEquals("delete methodo should return 204", 204, deleteResponse.getStatusCode());
        
        Response getDeletedBookResponse = new BookOperations().getBook(fetchedId);
        assertEquals("fetching delted book should return 404", 404, getDeletedBookResponse.getStatusCode());
        
    }
        */
    
}
