package com.example.retro;

import java.util.Objects;

public class Game {
    private final String name;
    private final int year;
    private final String releasedPlatform;
    private final String coverImageURL;
    private boolean isRentable;

    public Game(String name, int year, String releasedPlatform, String coverImageURL, boolean isRentable) {
        this.name = name;
        this.year = year;
        this.releasedPlatform = releasedPlatform;
        this.isRentable = isRentable;
        this.coverImageURL = coverImageURL;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }


    public boolean isRentable() {
        return isRentable;
    }

    public void setRentable(boolean rentable) {
        isRentable = rentable;
    }

    public String getReleasedPlatform() {
        return releasedPlatform;
    }

    public String getCoverImageURL() {
        return coverImageURL;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return year == game.year && isRentable == game.isRentable && Objects.equals(name, game.name) && Objects.equals(releasedPlatform, game.releasedPlatform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, releasedPlatform, isRentable);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", releasedPlatform='" + releasedPlatform + '\'' +
                ", coverImageURL='" + coverImageURL + '\'' +
                ", isRentable=" + isRentable +
                '}';
    }
}
