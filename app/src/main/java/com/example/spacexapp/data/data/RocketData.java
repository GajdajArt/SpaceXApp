package com.example.spacexapp.data.data;

public class RocketData {

    private String imageUrl;

    private String title;

    public RocketData(String title, String imageUrl) {
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
}
