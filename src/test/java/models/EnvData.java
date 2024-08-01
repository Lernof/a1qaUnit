package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EnvData {
    @JsonProperty("host")
    private String host;
}
