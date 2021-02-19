package utilities;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.ArrayList;

public class Utils {
    public static JsonNode convertToJson(ArrayList obj){
        return Json.toJson(obj);
    }
}
