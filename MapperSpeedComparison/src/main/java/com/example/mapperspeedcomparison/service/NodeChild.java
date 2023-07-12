package com.example.mapperspeedcomparison.service;

import com.example.mapperspeedcomparison.repository.NodeEntity;

public class NodeChild {
    private Long id;
    private String childDataEntity;
    private NodeEntity node;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChildDataEntity() {
        return childDataEntity;
    }

    public void setChildDataEntity(String childDataEntity) {
        this.childDataEntity = childDataEntity;
    }

    public NodeEntity getNode() {
        return node;
    }

    public void setNode(NodeEntity node) {
        this.node = node;
    }
}
