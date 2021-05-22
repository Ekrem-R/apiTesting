package pojo_tests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.TodosPojo;
import utilities.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class PostRequestPojo01 extends JsonPlaceHolderBaseUrl {
    /*
        When
            I send POST Request to the URL https://jsonplaceholder.typicode.com/todos
            with Post Request body  {
                                        "userId": 21,
                                        "id": 201,
                                        "title": "Tidy your room",
                                        "completed": false
                                     }
        Then
            Status code is 201
            And response body is like {
                                        "userId": 21,
                                        "id": 201,
                                        "title": "Tidy your room",
                                        "completed": false
                                      }
     */
    @Test
    public void post01(){
        spec.pathParam("todosName","todos");
        // Set the expected data
        TodosPojo expectedPojo=new TodosPojo(21,"Tidy your room",false);
        System.out.println(expectedPojo);
        System.out.println(expectedPojo.getUserId());
        System.out.println(expectedPojo.getTitle());
        System.out.println(expectedPojo.isCompleted());

        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expectedPojo).post("/{todosName}");
        response.prettyPrint();

         // Use GSON for deserialization (json-> Java)
        TodosPojo actualPojo=response.as(TodosPojo.class);
        System.out.println("actual data from GSON "+actualPojo);
        assertEquals(201,response.statusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo.isCompleted());

        //Use Object Mapper for deserialization
        TodosPojo actualPojo02= JsonUtil.convertJsonToJava(response.asString(),TodosPojo.class);
        System.out.println("Actual data from object mapper: "+actualPojo02);
        assertEquals(201,response.statusCode());
        assertEquals(expectedPojo.getUserId(),actualPojo02.getUserId());
        assertEquals(expectedPojo.getTitle(),actualPojo02.getTitle());
        assertEquals(expectedPojo.isCompleted(),actualPojo02.isCompleted());





    }









}
