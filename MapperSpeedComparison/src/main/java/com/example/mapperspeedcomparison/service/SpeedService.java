package com.example.mapperspeedcomparison.service;

import com.example.mapperspeedcomparison.mapper.mapstruct.MapStructConfig;
import com.example.mapperspeedcomparison.repository.NodeChildEntity;
import com.example.mapperspeedcomparison.repository.NodeEntity;
import com.example.mapperspeedcomparison.repository.SpeedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class SpeedService {
    public final static int RACE_LAPS = 500000;
    private final SpeedRepository speedRepository;
    private final ModelMapper modelMapper;

    public List<NodeEntity> getAllNodes() {
        return speedRepository.findAll();
    }

    public SpeedService(SpeedRepository speedRepository, ModelMapper modelMapper) {
        this.speedRepository = speedRepository;
        this.modelMapper = modelMapper;
    }

    public void raceModelMapper(List<Node> nodes) {
        for(int i = 0; i < RACE_LAPS; i++){
            Node node = new Node();
            NodeEntity nodeEntity = modelMapper.map(node, NodeEntity.class);

            NodeChild nodeChild = new NodeChild();
            NodeChildEntity nodeChildEntity = modelMapper.map(nodeChild, NodeChildEntity.class);
            nodeChildEntity.setNode(nodeEntity);
            nodeEntity.getNodeChildEntities().add(nodeChildEntity);
        }
    }

    public void raceMapStruct(List<Node> nodes) {
        for(int i = 0; i < RACE_LAPS; i++) {
            Node node = new Node();
            NodeEntity nodeEntity = MapStructConfig.MAPSTRUCT.convertModelToEntity(node);

            NodeChild nodeChild = new NodeChild();
            NodeChildEntity nodeChildEntity = MapStructConfig.MAPSTRUCT.convertChildModeltoEntity(nodeChild);
            nodeChildEntity.setNode(nodeEntity);
            nodeEntity.getNodeChildEntities().add(nodeChildEntity);
        }
    }

    public void deleteAllEntries() {
        speedRepository.deleteAll();
    }

    public void writeResultToFile(String fileName, String result) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
