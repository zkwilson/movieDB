package com.example.SpringBootLab.controller;

public class Movie {
    private int id = 0;
    private String title;
    private String category;
    private String rating;
    private static int count = 0;

    public Movie() {
        id = ++count;
    }
    public Movie(String title, String category, String rating) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        id = ++count;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
