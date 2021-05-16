package homoworktest;

import baseUrls.RestFul_Booker_HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class homework02 extends RestFul_Booker_HerokuAppBaseUrl {
     /*
            When
			    I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/1001
			Then
				HTTP Status code should be 404
			And
				Status Line should be HTTP/1.1 404 Not Found
			And
	            Response body contains "Not Found"
	        And
	            Response body does not contain "TechProEd"
	        And
	            Server is "Cowboy"
     */
    @Test
    public void get01(){
        spec.pathParams("first","booking","second",1);
        Response response=given().spec(spec).when().get("/{first}/{second}");
        //response.prettyPrint();
        response.then().assertThat().statusCode(404).statusLine("HTTO/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not found"));
        assertTrue(response.asString().contains("TechProEd"));
        assertEquals(response.getHeader("Server"),"Cowboy");
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Status Line: "+response.getStatusLine());

    }
}
