package com.moviesapi;

import com.google.gson.annotations.SerializedName;

public class Movie implements Content{
    private String title;
    private String year;
    private String image;

    @SerializedName("imDbRating")
    private String rating;

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String urlImage() {
        return image;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String rating() {
        return rating;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    @Override
    public String year() {
        return year;
    }
    
}
