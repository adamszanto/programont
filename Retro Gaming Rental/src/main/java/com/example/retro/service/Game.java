package com.example.retro.service;

import java.util.Objects;

public class Game {
    private Long id;
    private String name;
    private int year;
    private String releasedPlatform;
    private String coverImageURL;


    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReleasedPlatform() {
        return releasedPlatform;
    }

    public void setReleasedPlatform(String releasedPlatform) {
        this.releasedPlatform = releasedPlatform;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }

    public void setCoverImageURL(String coverImageURL) {
        this.coverImageURL = coverImageURL;
    }
}
