package homoworktest;

import baseUrls.RestFul_Booker_HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class homework1 extends RestFul_Booker_HerokuAppBaseUrl {
     /*
    In Api test cases and automation scripts we use "Given", "When", "Then", and "And"
    "Given" : It declares prerequisites
    "When" : It declares the action which user will perform
    "Then" : It declares outputs
    "And" : It can be used after "Given", "When", and "Then" for multiple actions
     */

    /*
    When
		     I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
		 Then
		     HTTP Status Code should be 200
		 And
		     Content Type should be JSON
		 And
		     Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void get01(){
        spec.pathParams("booking","booking","id",3);
        Response response= given().spec(spec).when().get("/{booking}/{id}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

        System.out.println("status code: "+response.getStatusCode());
        System.out.println("content type: "+response.getContentType());
        System.out.println("status line: "+response.getStatusLine());
    }
}
