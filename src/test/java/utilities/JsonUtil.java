package utilities;

import org.codehaus.jackson.map.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

import java.io.IOException;

public class JsonUtil {
    //Create two methods for de-serialization and serialization by using object mapper
    //We will create to methods and we will use them again and again

    //Creation method for de-serialization
    //1.Step: Create an object from Object Mapper class
    private static ObjectMapper mapper;
    static {
        mapper=new ObjectMapper();
    }

    //2.Step: Create method for de-serialization (Json->Java)
    //Since we need flexibility in return type(because in Java there are
    //many type objects) we used generic method
    public static <T> T convertJsonToJava(String json,Class<T> cls){
        T javaResult=null;
        try {
            javaResult=mapper.readValue(json,cls);//use readValue() from ObjectMapper for de-serialization
        } catch (IOException e) {
            System.out.println("Json could not be converted to Java "+e.getMessage());
        }
        return javaResult;

    }
    //create a method for Serialization (java-json)
    public static String convertJavaToJson(Object obj){
        String jsonResult=null;
        try {
             jsonResult=mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;

    }




}
