package utils;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;

public class APIUtils {

    private final static SettingsTestData settings = new SettingsTestData();
    private final static String baseURI = settings.getEnvData().getHost();

    public static Response getMethod(String endpoint){
        RestAssured.baseURI = baseURI;
        return RestAssured.given()
                .when()
                .get(endpoint);
    }

    public static <T> Response postMethod(String endpoint, T entry){
        RestAssured.baseURI = baseURI;
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .body(entry)
                .post(endpoint);
    }
}
