
package se.nackademin.rest.test;


import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import java.util.Random;
import java.util.UUID;
import se.nackademin.rest.test.model.*;


public class BookOperations {
    
        private static final String BASE_URL = "http://localhost:8080/librarytest/rest/";
        private String jsonString = "";
    public SingleBook getBook(int id){
        return given().accept(ContentType.JSON).get(BASE_URL + "books/" + id).as(SingleBook.class);
    }

    public Response updateBook(SingleBook bookToBeUpdated){
        return given().accept(ContentType.JSON).contentType(ContentType.JSON).body(bookToBeUpdated).put(BASE_URL + "books").prettyPeek();
    }
    public SingleAuthor getAuthorById(int id){
        return given().accept(ContentType.JSON).get("/librarytest/rest/authors/" + id).as(SingleAuthor.class);
    }
    public SingleAuthor getAuthorByBookId(int bookId){
        return given().accept(ContentType.JSON).get("/librarytest/rest/books/" + bookId + "/authors").as(SingleAuthor.class);
    }
    public Response updateBooksAuthor(SingleAuthor authorToBeUpdated, int bookId) {
        return given().accept(ContentType.JSON).contentType(ContentType.JSON).body(authorToBeUpdated).put(BASE_URL + "books/" + bookId + "/authors").prettyPeek();
    }
    /**
     * *
     * public Response createRandomBook(){ String resourceName = "books"; String
     * title = UUID.randomUUID().toString(); String description =
     * UUID.randomUUID().toString(); String isbn = UUID.randomUUID().toString();
     *
     * String postBodyTemplate = "" +"{\n" +"\"book\":\n" +" {\n" +"
     * \"description\":\"%s\",\n" +" \"isbn\":\"%s\",\n" + " \"nbOfPage\":%s,\n"
     * + " \"title\":\"%s\"\n" + " }\n" + "}";
     *
     * String postBody = String.format(postBodyTemplate, description, isbn,"" +
     * new Random().nextInt(500) ,title); jsonString = postBody;
     *
     * Response postResponse =
     * given().contentType(ContentType.JSON).body(postBody).post(BASE_URL +
     * resourceName); return postResponse; } public String
     * formatBookIntoJson(String title, String description, String isbn){ String
     * resourceName = "books"; String postBodyTemplate = "" +"{\n"
     * +"\"book\":\n" +" {\n" +" \"description\":\"%s\",\n" +"
     * \"isbn\":\"%s\",\n" + " \"nbOfPage\":%s,\n" + " \"title\":\"%s\"\n" + "
     * }\n" + "}";
     *
     * String postBody = String.format(postBodyTemplate, description, isbn,"" +
     * new Random().nextInt(500) ,title); return postBody;
     *
     * }
     * public String getLatestJsonString(){ return jsonString; } public Response
     * getAllBooks(){ String resourceName = "books"; Response getResponse =
     * given().accept(ContentType.JSON).get(BASE_URL +
     * resourceName).prettyPeek(); return getResponse; } public Response
     * deleteBook(int id){ String deleteResourceName = "books/" + id; Response
     * deleteResponse = delete(BASE_URL + deleteResourceName); return
     * deleteResponse; 
    }
     */
    }

