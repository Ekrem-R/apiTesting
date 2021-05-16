package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {
    Map<String,String> bookingDatesMap= new HashMap<>();
    Map<String,Object> bookingDetailsMap=new HashMap<>();

    public Map<String,Object> setUpData(){
        bookingDatesMap.put("checkin","2016-01-28");
        bookingDatesMap.put("checkout","2018-10-26");
        bookingDetailsMap.put("firstname","Jim");
        bookingDetailsMap.put("lastname","Jackson");
        bookingDetailsMap.put("totalprice",727);
        bookingDetailsMap.put("depositpaid",true);
        bookingDetailsMap.put("bookingdates",bookingDatesMap);
        bookingDetailsMap.put("additionalneeds","Breakfast");

        return bookingDetailsMap;
    }
}
