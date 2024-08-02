package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Env;
import models.EnvData;
import models.Post;
import models.User.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SettingsTestData {
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String RESOURCES_PATH = "src/test/resources/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String TEST_DATA = RESOURCES_PATH + "test_data/";
    private final String POSTS = TEST_DATA + "posts.json";
    private final String USERS = TEST_DATA + "users.json";
    private final String ENTITY = TEST_DATA + "post_entity.json";

    private final Env CURRENT_ENVIRONMENT = deserialize(RESOURCES_PATH + "env.json", Env.class);

    public EnvData getEnvData(){
        return deserialize(String.format("%s%s.json", ENVIRONMENT_PATH, CURRENT_ENVIRONMENT.getEnv()), EnvData.class);
    }

    public Post getPostEntity(){
        return deserialize(ENTITY, Post.class);
    }

    public List<Post> getPosts(){
        return getData(POSTS, new TypeReference<>(){});
    }

    public List<User> getUsers(){
        return getData(USERS, new TypeReference<>(){});
    }

    private <T> T deserialize(String file, Class<T> clazz){
        try {
            return objectMapper.readValue(new File(file), clazz);
        } catch(IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to deserialize " + file, e);
        }
    }

    private <T> T getData(String file, TypeReference<T> typeReference){
        try {
            return objectMapper.readValue(new File(file), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Failed to deserialized - %s", file), e);
        }
    }
}
