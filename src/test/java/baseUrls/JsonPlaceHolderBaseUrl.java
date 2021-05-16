package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    //1)Create RequestSpecification object
    protected RequestSpecification spec;

    //If you use @Before annotation before a method, it means the method will be executed before every test method
    @Before
    public void setUp(){
        String url="https://jsonplaceholder.typicode.com";
        spec=new RequestSpecBuilder().setBaseUri(url).build();
    }
}
