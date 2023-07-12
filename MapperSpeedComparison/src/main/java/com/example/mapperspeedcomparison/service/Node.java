package com.example.mapperspeedcomparison.service;

import com.example.mapperspeedcomparison.repository.NodeChildEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private Long id;
    private String data;
    private List<NodeChild> nodeChilds = new ArrayList<>();

    public Node() {
        this.data = "Traveling mock data inside of the Node instance";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<NodeChild> getNodeChilds() {
        return nodeChilds;
    }

    public void setNodeChilds(List<NodeChild> nodeChilds) {
        this.nodeChilds = nodeChilds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                '}';
    }
}
