package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by twer on 14-11-2.
 */
public class Touch {
    private String content;
    private String path;

    @JsonProperty
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
