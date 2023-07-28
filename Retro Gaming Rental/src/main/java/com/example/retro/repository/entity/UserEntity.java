package com.example.retro.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class UserEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "email", referencedColumnName = "email")
    private List<CurrentlyRentingEntity> rentingGames = new ArrayList<>();

    public UserEntity() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CurrentlyRentingEntity> getRentingGames() {
        return rentingGames;
    }

    public void setRentingGames(List<CurrentlyRentingEntity> rentingGames) {
        this.rentingGames = rentingGames;
    }

    public void addRentingGame(CurrentlyRentingEntity game) {
        rentingGames.add(game);
    }

    public void removeRentingGame(CurrentlyRentingEntity game) {
        rentingGames.remove(game);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(email, that.email) && Objects.equals(rentingGames, that.rentingGames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, rentingGames);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "email='" + email + '\'' +
                ", rentingGames=" + rentingGames +
                '}';
    }
}
