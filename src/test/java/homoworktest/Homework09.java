package homoworktest;

import baseUrls.JsonPlaceHolderBaseUrl;
import homeworkTest.JsonPlaceHolderTestUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Homework09 extends JsonPlaceHolderBaseUrl {
    /*
        When
            I send GET Request to https://jsonplaceholder.typicode.com/todos/2
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 Vegur"
            And header "Server" is "cloudflare"
     */
    @Test
    public void get01(){
        spec.pathParams("first","todos","second",2);
        JsonPlaceHolderTestUrl expectedDataObject=new JsonPlaceHolderTestUrl();
        Map<String,Object> expectedDataMap=expectedDataObject.setUpData();
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        System.out.println("Status code: "+response.getStatusCode());
        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));



    }
}
