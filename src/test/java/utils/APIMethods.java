package utils;

import io.restassured.response.Response;

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

}
