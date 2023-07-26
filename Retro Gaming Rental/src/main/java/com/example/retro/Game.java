package com.example.retro;

import java.util.Objects;

public class Game {
    private String name;
    private int year;
    private String releasedPlatform;
    private boolean isRentable;

    public Game(String name, int year, String publisher, boolean isRentable) {
        this.name = name;
        this.year = year;
        this.releasedPlatform = publisher;
        this.isRentable = isRentable;
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


    public boolean isRentable() {
        return isRentable;
    }

    public void setRentable(boolean rentable) {
        isRentable = rentable;
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
}
