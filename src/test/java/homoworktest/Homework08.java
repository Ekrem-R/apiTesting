package homoworktest;

import baseUrls.DummyRestapiexampleBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static org.testng.AssertJUnit.assertEquals;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.testng.AssertJUnit.assertTrue;

import static io.restassured.RestAssured.*;

public class Homework08 extends DummyRestapiexampleBaseUrl {
    /*
 When
         I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
     Then
         Status code is 200
         1)Print all ids greater than 10 on the console
           Assert that there are 14 ids greater than 10
         2)Print all ages less than 30 on the console
           Assert that maximum age is 23
         3)Print all employee names whose salaries are greater than 350,000
           Assert that "Charde Marshall" is one of the employees whose salary is greater than 350,000
 */
    @Test
    public void get01(){
        spec.pathParam("first","employees");
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        System.out.println("Status Code: "+response.getStatusCode());
        JsonPath json=response.jsonPath();
        List<Integer> idList= json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
        System.out.println(idList);
        assertEquals(14,idList.size());
        List<Integer> ageList=json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
        System.out.println(ageList);
        List<Integer> listAge=new ArrayList<>();
        for(Integer w:ageList){
            listAge.add(Integer.valueOf(w));
        }
        Collections.sort(listAge);
        assertEquals(Integer.valueOf(23),listAge.get(listAge.size()-1));

        List<String> nameList=json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
        System.out.println(nameList);
        assertTrue("The name you searched for is not in the list",nameList.contains("Charde Marshall"));

    }
}
