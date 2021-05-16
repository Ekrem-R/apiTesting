package post_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData1;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class PostRequest01 extends HerokuappBaseUrl {
    /*
    When
	 		I send POST Request to the Url https://restful-booker.herokuapp.com/booking
	 		with the request body {
								    "firstname": "Selim",
								    "lastname": "Ak",
								    "totalprice": 11111,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2020-09-09",
								        "checkout": "2020-09-21"
								     }
								  }
	 	Then
	 		Status code is 200
	 		And response body should be like {
											    "bookingid": 11,
											    "booking": {
											        "firstname": "Selim",
											        "lastname": "Ak",
											        "totalprice": 11111,
											        "depositpaid": true,
											        "bookingdates": {
											            "checkin": "2020-09-09",
											            "checkout": "2020-09-21"
											        }
											    }
											 }
     */
    @Test
    public void post01(){
        //1) Set the url
        spec.pathParam("first","booking");
        //2) Set the expected data
        HerOkuAppTestData1 expectedData= new HerOkuAppTestData1();
        Map<String, Object> expectedDataMap = expectedData.expectedDataSetUp();


        //3)Send POST request
        Response response=given().spec(spec).contentType(ContentType.JSON).
                body(expectedData.expectedDataSetUp()).when().post("/{first}");
        response.prettyPrint();
        Map<String,Object> actualDataMap = response.as(HashMap.class); //Gson
        System.out.println(actualDataMap);
        assertEquals(expectedDataMap.get("firstname"),((Map) actualDataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),((Map) actualDataMap.get("booking")).get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),((Map) actualDataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),((Map) actualDataMap.get("booking")).get("depositpaid"));
        assertEquals(expectedDataMap.get("checkin"),((Map) actualDataMap.get("booking")).get("bookingdates.checkin"));
        assertEquals(expectedDataMap.get("checkin"),((Map) actualDataMap.get("booking")).get("bookingdates.checkout"));

        //2.Way
        JsonPath json=response.jsonPath();
        assertEquals(expectedDataMap.get("firstname"),json.getString("booking.firstname"));
        assertEquals(expectedDataMap.get("lastname"),json.getString("booking.lastname"));
        assertEquals(expectedDataMap.get("totalprice"),json.getInt("booking.totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),json.getBoolean("booking.depositpaid"));
        assertEquals(expectedData.bookingDatesSetUp().get("checkin"),json.getString("booking.bookingdates.checkin"));
        assertEquals(expectedData.bookingDatesSetUp().get("checkout"),json.getString("booking.bookingdates.checkout"));



    }
}
