package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import models.Post;
import models.User.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIMethods;
import utils.JsonValidator;
import utils.SettingsTestData;

public class APITest {
    private final ObjectMapper mapper = new ObjectMapper();
    private final SettingsTestData setting = new SettingsTestData();

    private final Response allPosts = APIMethods.getAllPosts();
    private final Response ninetyninePerson = APIMethods.getSpecificPost(99);
    private final Response postPost = APIMethods.postUser(setting.getPostEntity());

    @Test
    public void APItesting() throws JsonProcessingException {
        //Step 1
        Assert.assertEquals(allPosts.getStatusCode(), 200, "Status code is not 200");
        Assert.assertTrue(JsonValidator.isValid(allPosts.asString()), "List content is not json");
        JSONArray postsArray = new JSONArray(allPosts.asString());
        Assert.assertTrue(JsonValidator.isSortedById(postsArray), "Id's not sorted by ascending order");

        //Step 2
        Assert.assertEquals(ninetyninePerson.statusCode(), 200, "Invalid status code");
        Assert.assertEquals(ninetyninePerson.jsonPath().getInt("id"), setting.getPosts().get(98).getId(),
        "id is not equal to " + setting.getPosts().get(98).getId());
        Assert.assertEquals(ninetyninePerson.jsonPath().getInt("userId"),setting.getPosts().get(98).getUserId(),
                "userId is not equal to " + setting.getPosts().get(98).getUserId());
        Assert.assertNotNull(ninetyninePerson.jsonPath().getString("body"));
        Assert.assertNotNull(ninetyninePerson.jsonPath().getString("title"));

        //step 3
        Assert.assertEquals(APIMethods.getSpecificPost(150).statusCode(), 404,
                "Status code is not 404");

        //step 4
        Assert.assertEquals(setting.getPostEntity(), mapper.readValue(APIMethods.postUser(setting.getPostEntity()).body().asString(), Post.class));

        //step 5
        Assert.assertEquals(mapper.convertValue(APIMethods.getAllUsers().jsonPath().getList("").get(4), User.class), setting.getUsers().get(4));

        //step 6
        Assert.assertEquals(APIMethods.getSpecificUser(5).statusCode(), 200,
                "invalid status code");
        Assert.assertEquals(setting.getUserEntity(), mapper.readValue(APIMethods.getSpecificUser(5).body().asString(), User.class));
    }
}
