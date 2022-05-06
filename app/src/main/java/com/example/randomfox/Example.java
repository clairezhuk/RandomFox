package com.example.randomfox;

import java.util.HashMap;
import java.util.Map;

public class Example {
    private String image;
    private String link;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
