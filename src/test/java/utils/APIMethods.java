package utils;

import io.restassured.response.Response;
import models.Post;

public class APIMethods {
    public static Response getAllPosts(){
            return APIUtils.getMethod("/posts");
    }
    public static Response getSpecificPerson(int personId){
        return APIUtils.getMethod("/posts/" + personId);
    }
    public static Response getSpecificUser(int userId){
        return APIUtils.getMethod("/users/" + userId);
    }
    public static Response getAllUsers(){
        return APIUtils.getMethod("/users");
    }
    public static <T> Response postUser(T entity){
        return APIUtils.postMethod("/posts",entity);
    }
}
