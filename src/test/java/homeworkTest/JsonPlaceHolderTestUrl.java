package homeworkTest;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestUrl {
    public Map<String, Object> setUpData() {
        Map<String,Object> expectedDataMap=new HashMap<>();
        expectedDataMap.put("statusCode",200);
        expectedDataMap.put("completed",false);
        expectedDataMap.put("userId",1);
        expectedDataMap.put("title","quis ut nam facilis et officia qui");
        expectedDataMap.put("Via","1.1 vegur");
        expectedDataMap.put("Server","cloudflare");
        return expectedDataMap;


    }
}
