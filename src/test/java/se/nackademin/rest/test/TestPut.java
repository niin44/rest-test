/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.rest.test;


import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import java.util.UUID;
import static org.junit.Assert.*;
import org.junit.Test;
import se.nackademin.rest.test.model.*;

/**
 *
 * @author niin
 */
public class TestPut {
    private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";
    BookOperations bookOp = new BookOperations();
    @Test
    public void testUpdateBook(){
        Book book = bookOp.getBook(3).getBook();
        SingleAuthor singleAuthor = bookOp.getAuthorByBookId(3);
        book.setAuthor(singleAuthor.getAuthor());
        book.setDescription(UUID.randomUUID().toString());
        System.out.println(book.getDescription());
        
        SingleBook singleBook = new SingleBook(book);
        
        Response putResponse = bookOp.updateBook(singleBook);
        assertEquals("Should return 200", 200, putResponse.getStatusCode());
        
        Book updatedBook = bookOp.getBook(3).getBook();
        assertEquals("Description should be updated", book.getDescription(), updatedBook.getDescription());
    }
    //*
    @Test
    public void testUpdateBooksAuthor() {
        int bookId = 3;
        SingleAuthor singleAuthor = bookOp.getAuthorByBookId(bookId);
        Author author = singleAuthor.getAuthor();
        author.setName(UUID.randomUUID().toString());
        System.out.println("Author: " + author.getName());
        
        singleAuthor = new SingleAuthor(author);
        Response putResponse = bookOp.updateBooksAuthor(singleAuthor, bookId);
        assertEquals("Should return status code 200", 200, putResponse.getStatusCode());

        Author updatedAuthor = bookOp.getAuthorByBookId(bookId).getAuthor();
        assertEquals("Should return new name", author.getName(), updatedAuthor.getName());
    }//*/
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
