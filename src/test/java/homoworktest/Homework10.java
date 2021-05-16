package homoworktest;

import baseUrls.RestFul_Booker_HerokuAppBaseUrl;
import homeworkTest.RestfulBookerTestData;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class Homework10 extends RestFul_Booker_HerokuAppBaseUrl {
     /*
     When
        I send GET Request to "https://restful-booker.herokuapp.com/booking/1"
     Then
        Response body should be like that;
        {
  {
    "firstname": "Susan",
    "lastname": "Wilson",
    "totalprice": 457,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2016-05-10",
        "checkout": "2019-06-03"
    },
    "additionalneeds": "Breakfast"
}
     */
    @Test
    public void get01(){
        spec.pathParams("first","booking","second",1);
        RestfulBookerTestData expectDataObject=new RestfulBookerTestData();
        Map<String,Object> expectDataMap=expectDataObject.setUpData();
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectDataMap.get("bookingdates")).get("checkin"),((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectDataMap.get("bookingdates")).get("checkout"),((Map)actualDataMap.get("bookingdates")).get("checkout"));

    }
}
