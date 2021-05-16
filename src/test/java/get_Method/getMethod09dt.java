package get_Method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class getMethod09dt extends JsonPlaceHolderBaseUrl {
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

        //Set the expected data
        JsonPlaceHolderTestData expectedDataObject=new JsonPlaceHolderTestData();


        Map<String,Object> expectedDataMap=expectedDataObject.setUpData();


        //Send the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Assertion
        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("Via"),response.getHeader("Via"));
        assertEquals(expectedDataMap.get("Server"),response.getHeader("Server"));

    }
}
