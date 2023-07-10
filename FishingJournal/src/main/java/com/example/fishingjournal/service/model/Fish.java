package com.example.fishingjournal.service.model;

import java.util.Date;

public class Fish {
    private String species;
    private int length;
    private int weight;
    private Date timestamp;

    public Fish() {
    }

    public Fish(String species, int length, int weight) {
        this.species = species;
        this.length = length;
        this.weight = weight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Fish{" +
                "species='" + species + '\'' +
                ", length=" + length +
                ", weight=" + weight +
                '}';
    }
}
