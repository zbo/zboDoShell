package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by twer on 14-11-1.
 */
public class Pwd {
    private String path;

    @JsonProperty
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
