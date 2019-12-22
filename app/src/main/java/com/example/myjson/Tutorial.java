package com.example.myjson;

public class Tutorial {
    String name, imageUrl, description;

    public Tutorial(String name, String imageUrl, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public String getDescription() {
        return description;
    }
}