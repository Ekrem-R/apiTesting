package homoworktest;

import baseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Homework03 extends JsonPlaceHolderBaseUrl {
    /*
    When
		 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23
		    And Accept type is “application/JSON”
		 Then
		    HTTP Status Code should be 200
		    And Response format should be “application/JSON”
		    And “title” is “et itaque necessitatibus maxime molestiae qui quas velit”,
		    And “completed” is false
		    And “userId” is 2
     */
    @Test
    public void get01(){
        spec.pathParams("first","todos","second",23);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
        assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
        assertTrue(response.asString().contains("\"completed\": false"));
        assertTrue(response.asString().contains("\"userId\": 2"));

    }
}
