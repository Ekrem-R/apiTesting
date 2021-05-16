package homoworktest;

import baseUrls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class homework04 extends JsonPlaceHolderBaseUrl {
     /*
   When
I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos
  And Accept type is "application/json"
  Then
  HTTP Status Code should be 200
  And Response format should be "application/json"
  And there should be 200 todos
  And "quis eius est sint explicabo" should be one of the todos
  And 2, 7, and 9 should be among the userIds
     */
    @Test
    public void get01(){
        spec.pathParam("first","todos");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("id",hasSize(200),"title",hasItem("quis eius est sint explicabo"),
                        "userId",hasItems(2,7,9));
    }
}
