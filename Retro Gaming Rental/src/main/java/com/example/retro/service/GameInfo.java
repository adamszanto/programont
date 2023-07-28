package com.example.retro.service;

import java.util.Objects;

public class GameInfo {
    private Long id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameInfo gameInfo = (GameInfo) o;
        return Objects.equals(id, gameInfo.id) && Objects.equals(name, gameInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GameInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
