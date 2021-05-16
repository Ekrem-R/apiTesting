package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData1 {

    public Map<String,Object> expectedDataSetUp(){
        Map<String,Object> expected=new HashMap<>();
        expected.put("userId",55);
        expected.put("title","Tidy your room");
        expected.put("completed",false);
        expected.put("id",201);

        return expected;
    }
}
