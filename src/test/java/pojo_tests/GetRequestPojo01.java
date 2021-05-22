package pojo_tests;

import base_urls.TechProBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.CoursePojo;
import pojos.LongDescriptionPojo;
import pojos.ShortDescriptionPojo;
import pojos.TitlePojo;
import utilities.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class GetRequestPojo01 extends TechProBaseUrl {
    /*
    When I sen GET request to https://api-techproed-test.herokuapp.com/courses/1
    Status Code should be 200 and response body should be like:
    {
    "_id": 1,
    "code": "",
    "title": {
        "en": "HTML5",
        "tr": ""
    },
    "shortDescription": {
        "en": "Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.",
        "tr": ""
    },
    "longDescription": {
        "en": "Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.",
        "tr": ""
    },
    "image": "html5.jpg",
    "slug": "html5",
    "__v": 0
}
     */

    @Test
    public void get01(){
        // Set the url
        spec.pathParam("id",1);
        //Set the expected data
        TitlePojo titlePojo=new TitlePojo("HTML5","");
        ShortDescriptionPojo shortDescription=new ShortDescriptionPojo("Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.","");
        LongDescriptionPojo longDescriptionPojo = new LongDescriptionPojo("Learn the anatomy of HTML syntax to structure your websites. Understand the HTML boilerplate and HTML doctypes. How to structure text in HTML. " +
                "How to structure HTML lists to create unordered and ordered lists. How to insert images using HTML.","");
        CoursePojo expectedPojo=new CoursePojo(titlePojo,shortDescription,longDescriptionPojo,"html5.jpg","html5");

        //Send the request
        Response response=given().spec(spec).when().get("/{id}");
        response.prettyPrint();

        //Assertion
        //Use GSON for deserialization
        CoursePojo actualPojo=response.as(CoursePojo.class);
        System.out.println(actualPojo);

        assertEquals(200,response.statusCode());
        assertEquals(expectedPojo.getTitle().getEn(),actualPojo.getTitle().getEn());
        assertEquals(expectedPojo.getTitle().getTr(),actualPojo.getTitle().getTr());
        assertEquals(expectedPojo.getShortDescription().getEn(),actualPojo.getShortDescription().getEn());
        assertEquals(expectedPojo.getShortDescription().getTr(),actualPojo.getShortDescription().getTr());
        assertEquals(expectedPojo.getLongDescription().getEn(),actualPojo.getLongDescription().getEn());
        assertEquals(expectedPojo.getLongDescription().getTr(),actualPojo.getLongDescription().getTr());
        assertEquals(expectedPojo.getImage(),actualPojo.getImage());
        assertEquals(expectedPojo.getSlug(),actualPojo.getSlug());

        //Use ObjectMapper for de-serialization
        CoursePojo actualPojo02= JsonUtil.convertJsonToJava(response.asString(),CoursePojo.class);
        System.out.println("Coming from ObjectMapper: " + actualPojo02);

        assertEquals(201, response.getStatusCode());
        //assertEquals(expectedPojo.get, actualPojo02.getUserId());
        assertEquals(expectedPojo.getTitle(), actualPojo02.getTitle());
        //assertEquals(expectedPojo.isCompleted(), actualPojo02.isCompleted());





    }
}
