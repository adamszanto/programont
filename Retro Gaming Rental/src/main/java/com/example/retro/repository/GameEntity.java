package com.example.retro.repository;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class GameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int year;
    private String releasedPlatform;
    private String coverImageURL;
    @Column(columnDefinition = "boolean default true")
    private boolean rentable;

    public GameEntity() {
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

    public boolean isRentable() {
        return rentable;
    }

    public void setRentable(boolean rentable) {
        this.rentable = rentable;
    }
}
