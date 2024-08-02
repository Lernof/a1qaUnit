package utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonValidator {
    public static boolean isValid(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException e) {
            try {
                new JSONArray(json);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSortedById(JSONArray jsonArray) {
        try {
            List<JSONObject> jsonObjects = IntStream.range(0, jsonArray.length())
                    .mapToObj(jsonArray::getJSONObject)
                    .collect(Collectors.toList());

            return IntStream.range(0, jsonObjects.size() - 1)
                    .allMatch(i -> jsonObjects.get(i).getInt("id") <= jsonObjects.get(i + 1).getInt("id"));
        } catch (JSONException e) {
            return false;
        }
    }
    public static String readJsonFile(String filePath) {
        try{
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e){
            e.getStackTrace();
            throw new RuntimeException();
        }
    }
}
