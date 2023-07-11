package com.example.mapperspeedcomparison.service;

import com.example.mapperspeedcomparison.mapper.mapstruct.MapStructConfig;
import com.example.mapperspeedcomparison.repository.NodeEntity;
import com.example.mapperspeedcomparison.repository.SpeedRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeedService {
    private final SpeedRepository speedRepository;
    private final ModelMapper modelMapper;

    public SpeedService(SpeedRepository speedRepository, ModelMapper modelMapper) {
        this.speedRepository = speedRepository;
        this.modelMapper = modelMapper;
    }

    public void raceModelMapper(List<Node> nodes) {
        for(int i = 0; i < 1000; i++){
            Node node = new Node();
            NodeEntity nodeEntity = modelMapper.map(node, NodeEntity.class);
            speedRepository.save(nodeEntity);
        }
    }

    public void raceMapStruct(List<Node> nodes) {
        for(int i = 0; i < 1000; i++) {
            Node node = new Node();
            NodeEntity nodeEntity = MapStructConfig.MAPSTRUCT.convertModelToEntity(node);
            speedRepository.save(nodeEntity);
        }
    }
}
