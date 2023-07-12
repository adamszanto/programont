package com.example.mapperspeedcomparison.repository;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="nodes")
public class NodeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dataEntity;
    @OneToMany(mappedBy = "node", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<NodeChildEntity> nodeChildEntities = new ArrayList<>();

    public NodeEntity() {
        this.dataEntity = "Traveling mock data inside of the Node instance";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataEntity() {
        return dataEntity;
    }

    public void setDataEntity(String dataEntity) {
        this.dataEntity = dataEntity;
    }

    public List<NodeChildEntity> getNodeChildEntities() {
        return nodeChildEntities;
    }

    public void setNodeChildEntities(List<NodeChildEntity> nodeChildEntities) {
        this.nodeChildEntities = nodeChildEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NodeEntity that = (NodeEntity) o;

        return Objects.equals(dataEntity, that.dataEntity);
    }

    @Override
    public int hashCode() {
        return dataEntity != null ? dataEntity.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NodeEntity{" +
                "dataEntity='" + dataEntity + '\'' +
                '}';
    }
}
