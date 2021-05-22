package patch_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData1;
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

public class PatchRequest01 extends JsonPlaceHolderBaseUrl {
    /*
    When
	 		I send PATCH Request to the Url https://jsonplaceholder.typicode.com/todos/198
	 		with the PUT Request body like {
										    "title": "Tidy your room",
										   }
	   Then
	   	   Status code is 200
	   	   And response body is like  {
									    "userId": 10,
									    "title": "Tidy your room",
									    "completed": true,
									    "id": 198
									  }
     */
    @Test
    public void patch01(){
        spec.pathParams("first","todos","second",198);
        JsonPlaceHolderTestData1 expected=new JsonPlaceHolderTestData1();
        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expected.expectedPatchDataSetUp()).when().
                patch("/{first}/{second}");
        response.then().assertThat().statusCode(200).
                body("title", Matchers.equalTo(expected.expectedDataSetUp().get("title")),
                        "userId",Matchers.equalTo(expected.expectedDataSetUp().get("userId")),
                        "completed",Matchers.equalTo(expected.expectedDataSetUp().get("completed")));

    }
}
