package post_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.HerOkuAppTestData1;
import test_data.JsonPlaceHolderTestData1;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class PostRequest02 extends JsonPlaceHolderBaseUrl {
    /*
    When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 200
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									  }
     */
    @Test
    public void post01(){
        spec.pathParam("first","todos");
        JsonPlaceHolderTestData1 expectedData=new JsonPlaceHolderTestData1();
        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expectedData.expectedDataSetUp()).when().
                post("/{first}");
        response.prettyPrint();

        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);
        assertEquals(201,response.getStatusCode());
        assertEquals(expectedData.expectedDataSetUp().get("completed"),actualData.get("completed"));
        assertEquals(expectedData.expectedDataSetUp().get("title"),actualData.get("title"));
        assertEquals(expectedData.expectedDataSetUp().get("userId"),actualData.get("userId"));


        //2.Way
        JsonPath json=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getBoolean("completed"),expectedData.expectedDataSetUp().get("completed"),"completed does not match");
        softAssert.assertEquals(json.getString("title"),expectedData.expectedDataSetUp().get("title"),"title does not match");
        softAssert.assertEquals(json.getInt("userId"),expectedData.expectedDataSetUp().get("userId"),"userId does not match");

        softAssert.assertAll();


    }
}
