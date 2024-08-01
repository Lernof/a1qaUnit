package models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Post {
    private String userId;
    private String id;
    private String title;
    private String body;
}
