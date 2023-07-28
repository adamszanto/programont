package com.example.retro.service;

import java.util.Objects;

public class Game {
    private String name;
    private int year;
    private String releasedPlatform;
    private String coverImageURL;
    private boolean rentable;


    public Game() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return year == game.year && rentable == game.rentable && Objects.equals(name, game.name) && Objects.equals(releasedPlatform, game.releasedPlatform) && Objects.equals(coverImageURL, game.coverImageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, releasedPlatform, coverImageURL, rentable);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", releasedPlatform='" + releasedPlatform + '\'' +
                ", coverImageURL='" + coverImageURL + '\'' +
                ", rentable=" + rentable +
                '}';
    }
}
