package com.example.admin.flickerweekendtest;

/**
 * Created by  Admin on 12/1/2017.
 */

public class Image {
    String title;
    String description;
    String imgSrc;

    public Image(String title, String description, String imgSrc) {
        this.title = title;
        this.description = description;
        this.imgSrc = imgSrc;
    }

    public Image() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }
}
