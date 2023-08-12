package com.adam.kafkatutorial.controller.dto;

import com.adam.kafkatutorial.kafka.payload.Action;

public class UserInput {
    private String owner;
    private Action action;
    private String data;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "owner='" + owner + '\'' +
                ", action=" + action +
                ", data='" + data + '\'' +
                '}';
    }
}
