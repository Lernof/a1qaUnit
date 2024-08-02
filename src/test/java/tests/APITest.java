package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIMethods;
import utils.SettingsTestData;

import java.util.stream.Stream;

public class APITest {

    private SettingsTestData setting = new SettingsTestData();

    @Test
    public void APItesting(){
        System.out.println("");
        Response resp = APIMethods.postUser(setting.getPostEntity());
        System.out.println(resp.jsonPath().getString("city"));
    }
}
