package put_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData1;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;
import test_data.AgroMonitoringTestData;
import test_data.HerOkuAppTestData1;
import test_data.JsonPlaceHolderTestData1;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class PutRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    “userId”: 21,
										    “title”: “Wash the dishes”,
										    “completed”: false
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like   {
									    “userId”: 21,
									    “title”: “Wash the dishes”,
									    “completed”: false,
									    }
     */
    @Test
    public void put01(){
        spec.pathParams("first","todos","second",198);
        JsonPlaceHolderTestData1 expected =new JsonPlaceHolderTestData1();
        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expected.expectedDataSetUp()).when().put("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actual=response.as(HashMap.class);
        System.out.println(actual);
        assertEquals(expected.expectedDataSetUp().get("completed"),actual.get("completed"));
    }


}
