package com.example.mapperspeedcomparison.mapper.mapstruct;

import com.example.mapperspeedcomparison.repository.NodeEntity;
import com.example.mapperspeedcomparison.service.Node;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapStructConfig {

    MapStructConfig MAPSTRUCT = Mappers.getMapper(MapStructConfig.class);
    @Mapping(source = "data", target = "dataEntity")
    NodeEntity convertModelToEntity(Node node);
}