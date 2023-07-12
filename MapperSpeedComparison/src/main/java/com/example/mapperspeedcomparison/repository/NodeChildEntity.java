package com.example.mapperspeedcomparison.repository;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "nodechilds")
public class NodeChildEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String childDataEntity;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {})
    @JoinColumn(name="nodes_id", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeChildEntity that = (NodeChildEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(childDataEntity, that.childDataEntity))
            return false;
        return Objects.equals(node, that.node);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (childDataEntity != null ? childDataEntity.hashCode() : 0);
        result = 31 * result + (node != null ? node.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "NodeChildEntity{" +
                "id=" + id +
                ", childDataEntity='" + childDataEntity + '\'' +
                ", node=" + node +
                '}';
    }
}
