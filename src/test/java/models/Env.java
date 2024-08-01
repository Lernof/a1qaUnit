package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Env {
    @JsonProperty("env")
    private String env;
}
