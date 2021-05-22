package delete_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class DeleteRequest01 extends JsonPlaceHolderBaseUrl {
     /*
        When
            I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
        Then
            Status code is 200
            And Response body is {}
    */
    @Test
    public void delete01(){
        spec.pathParams("first","todos","second",19);
        Map<String,Object> expected= new HashMap<>();
        Response response=given().spec(spec).
                when().delete("/{first}/{second}");
        response.prettyPrint();

        //Assertion
        //Use GSON for De-serialization
        Map<String,Object> actual=response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(expected.get(""),actual.get(""));
        assertEquals(expected,actual);
        assertEquals(expected.size(),actual.size());


    }
}
