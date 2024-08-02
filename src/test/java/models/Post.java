package models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Post {
    int userId;
    String title;
    int id;
    String body;

//    public Post(int userId, int id, String title, String body){
//        this.userId = userId;
//        this.id = id;
//        this.title = title;
//        this.body = body;
//    }
}
