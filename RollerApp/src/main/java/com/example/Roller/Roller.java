package com.example.Roller;

import java.util.Objects;

public class Roller {
    private String name;
    private double price;
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roller roller = (Roller) o;
        return Double.compare(roller.price, price) == 0 &&
                stock == roller.stock &&
                Objects.equals(name, roller.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, stock);
    }
}


