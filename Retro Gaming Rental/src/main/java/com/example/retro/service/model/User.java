package com.example.retro.service.model;

import com.example.retro.repository.entity.CurrentlyRentingEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String email;
    private List<CurrentlyRenting> rentingGames = new ArrayList<>();

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CurrentlyRenting> getRentingGames() {
        return rentingGames;
    }

    public void setRentingGames(List<CurrentlyRenting> rentingGames) {
        this.rentingGames = rentingGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(rentingGames, user.rentingGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, rentingGames);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", rentingGames=" + rentingGames +
                '}';
    }
}
