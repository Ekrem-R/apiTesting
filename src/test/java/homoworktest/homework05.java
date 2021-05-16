package homoworktest;

import baseUrls.RestFul_Booker_HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class homework05 extends RestFul_Booker_HerokuAppBaseUrl {
    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  		Among the data there should be someone whose first name is “Mark” and last name is “Ericsson”
     */
    @Test
    public void get01(){
        spec.pathParam("first","booking").queryParams("firstname","Eric","lastname","Brown");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //response.then().assertThat().statusCode(200);
        //assertTrue(response.asString().contains("bookingid"));
    }

}
