package com.pr.gfce.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.json.XML;

/**
 * @author Oscar Blancarte
 */
public class JsonConverter {
    
    public static <T> T toObject(String obj, Class<T> clazz){
        Gson g = new Gson();
        return g.fromJson(obj, clazz);
    }
    
    public static Map<String,Object> convertMap(Object obj){
        Gson g = new Gson();
        return g.fromJson(obj.toString(), new TypeToken<Map<String, Object>>(){}.getType());
    }
    
    public static String toJson(Object obj,boolean format){
        Gson g = null;
        if(format){
            g = new GsonBuilder().setPrettyPrinting().create();
        }else{
            g = new Gson();
        }
        return g.toJson(obj);
    }
    
    public static String getRootNameElement(String xml) {
        JsonElement jelement = new JsonParser().parse(xml);
        JsonObject  jobject = jelement.getAsJsonObject();
        Set<Map.Entry<String,JsonElement>> set = jobject.entrySet();
        for (Map.Entry<String, JsonElement> entry : set) {
            return entry.getKey();
        }
        throw new RuntimeException("No se encontró el elemento raíz");
    }
    
    public static String fromXML(String xml){
        JSONObject xmlObject = XML.toJSONObject(xml);
        String json = xmlObject.toString(4);
        return json;
    }
}