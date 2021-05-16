package homeworkTest;

import java.util.HashMap;
import java.util.Map;

public class RestfulBookerTestData {
    Map<String,String> bookingDatesMap=new HashMap<>();
    Map<String,Object> bookingDetailsMap=new HashMap<>();

    public Map<String,Object> setUpData(){
        bookingDatesMap.put("checkin","2016-05-10");
        bookingDatesMap.put("checkout","2019-06-03");
        bookingDetailsMap.put("firstname","Eric");
        bookingDetailsMap.put("lastname","Wilson");
        bookingDetailsMap.put("totalprice",838);
        bookingDetailsMap.put("depositpaid",true);
        bookingDetailsMap.put("additionalneeds", "Breakfast");
        return bookingDetailsMap;

    }
}
